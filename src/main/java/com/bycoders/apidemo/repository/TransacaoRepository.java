package com.bycoders.apidemo.repository;

import com.bycoders.apidemo.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
  Transacao findByTipo(int tipo);
}
