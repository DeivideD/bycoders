import { useEffect, useState } from "react"
import { api } from "../../services/api"
import { ModalRepresentante } from "../modal/modalRepresentante";
import { ModalUpload } from "../modal/modalUpload";

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

  let subtitle: HTMLHeadingElement;
  const [transacoes, setTransacao] = useState<Trasacao[]>([]);
  const [mensagem, setMensagem] = useState("");
  const [modalUploadIsOpen, setUploadIsOpen] = useState(false);
  const [modalRepresentanteIsOpen, setRepresentanteIsOpen] = useState(false);

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


  function hadleOpenUploadModal() {
    setUploadIsOpen(true);
  }

  function hadleCloseUploadModal() {
    setUploadIsOpen(false);
  }

  function hadleOpenRepresentanteModal() {
    setRepresentanteIsOpen(true);
  }

  function hadleCloseRepresentanteModal() {
    setRepresentanteIsOpen(false);
  }

  function atualizar () {
    setMensagem("Dados Atualizados");
    api.get('/transacoes')
      .then(response => setTransacao(response.data))
    setTimeout(() => { 
      setMensagem("")
    }, 5000);
  }

  return (
    <>
    <div>
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
        <button type="button" className="" onClick={hadleOpenUploadModal}>Importar CNAB</button>
         <button type="button" className="" onClick={hadleOpenRepresentanteModal}>Representantes</button>
      </div>

      <ModalUpload isOpen={modalUploadIsOpen} handleClose={hadleCloseUploadModal} atualizarTrasacoes={atualizar}/>
      <ModalRepresentante isOpen={modalRepresentanteIsOpen} handleClose={hadleCloseRepresentanteModal}/>
    </div>
  </>
  );
}