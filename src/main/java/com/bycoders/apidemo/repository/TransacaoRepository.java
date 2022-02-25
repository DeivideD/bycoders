package com.bycoders.apidemo.repository;

import com.bycoders.apidemo.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
  Transacao findByTipo(int tipo);

  @Query(value = "select t.descricao, l.nome, t.natureza, sum(m.valor) as total from movimentacao m\n" +
          "inner join loja l on m.loja_id  = l.id  \n" +
          "inner join transacao t on m.transacao_id  = t.id \n" +
          "group by  \n" +
          "t.descricao,\n" +
          "l.nome,\n" +
          "t.natureza\n" +
          "order by t.descricao", nativeQuery = true )
  List<Object> trasacoesPorLoja();
}
