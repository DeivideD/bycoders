import { useEffect, useState } from "react"
import { api } from "../../services/api"

interface Trasacao {
  transacao: string;
  loja: string;
  natureza: string;
  valor: number;
}

interface Transacao {
  tipo: string;
  natureza: string;
  valor: number;
}

interface ResumoMovimentacao {
  loja: string;
  movimentacoes: Transacao[];
  saldo: number;
}

export function Movimentacao() {

  const [transacoes, setTransacao] = useState<Trasacao[]>([]);

  const [mensagem, setMensagem] = useState("");

  useEffect(() => {
    api.get('/transacoes')
      .then(response => setTransacao(response.data))
  }, []);

  const lojasComMovimentacao = transacoes.map((item) => item.loja).filter((ele, pos, it) => it.indexOf(ele) === pos);

  const movimentacoesAgrupadas = () => {
    var trans: Transacao[] = [];
    var resumoPorLoja: ResumoMovimentacao[] = [];
    lojasComMovimentacao.forEach((loja) => {
      const mov = transacoes.filter((movimentacao) => movimentacao.loja.indexOf(loja) !== -1)
      mov.forEach((trasaction) => {
        trans.push({ tipo: trasaction.transacao, natureza: trasaction.natureza, valor: trasaction.valor });
      });

      const saldo = trans.reduce((acumulador, item) => {

        if (item.natureza === "Entrada") {
          acumulador += item.valor
        } else {
          acumulador -= item.valor
        }
        return acumulador;
      }, 0);
      resumoPorLoja.push({loja: loja, movimentacoes: trans, saldo: saldo} );
      trans = [];
    });
    return resumoPorLoja;
  }

  function atualizar () {
    api.get('/transacoes')
    .then(response => setTransacao(response.data))
    setMensagem("Dados Atualizados");
    setTimeout(() => { setMensagem(""); }, 3000);
  }

  return (
    <>
      <div className="div-table">
        <div className={mensagem === "" ? "none" : "alert"} > {mensagem}</div>
        <table>
          <thead>
            <tr>
              <th>Loja Com Movimentacao</th>
              <th>Lista de Operacoes</th>
              <th>Saldo Em Conta</th>
            </tr>

          </thead>
          <tbody>

            {movimentacoesAgrupadas().map(transaction => (

              <tr key={Math.random().toString(36)}>
                <th >{transaction.loja}</th>
                <th> 
                  {transaction.movimentacoes.map(opr => opr.tipo + " - ")}
                </th>
                <th>R$ {transaction.saldo.toFixed(2)}</th>
              </tr>
            ))}
          </tbody>
        </table>
        <button type="button" className="btnAtualizar" onClick={atualizar}>Atualizar</button>
      </div>
    </>
  );
}