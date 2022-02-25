package com.bycoders.apidemo.data;

import com.bycoders.apidemo.model.MovimentacaoLoja;
import com.bycoders.apidemo.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Configurable
public class TransacoesData {

  @Autowired
  private TransacaoService transacaoService;

  public List<MovimentacaoLoja> buscarTrasacoes(){
    List<MovimentacaoLoja> listMovimentacao = new ArrayList();

    List<Object[]> itens = transacaoService.trasacoesPorLoja();
    for( Object[] item : itens ) {
      MovimentacaoLoja movimentacaoLoja = new MovimentacaoLoja();
      movimentacaoLoja.setLoja(item[1].toString());
      movimentacaoLoja.setNatureza(item[2].toString());
      movimentacaoLoja.setTransacao(item[0].toString());
      movimentacaoLoja.setValor(Double.parseDouble(item[3].toString()));

      System.out.println(item[0].toString());
      System.out.println(item[1].toString());
      System.out.println(item[2].toString());
      System.out.println(item[3].toString());

      listMovimentacao.add(movimentacaoLoja);
    }

    return listMovimentacao;
  }
}
