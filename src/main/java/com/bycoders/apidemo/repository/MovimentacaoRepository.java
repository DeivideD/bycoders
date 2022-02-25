package com.bycoders.apidemo.repository;

import com.bycoders.apidemo.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}
