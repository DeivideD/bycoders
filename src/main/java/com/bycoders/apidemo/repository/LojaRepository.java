package com.bycoders.apidemo.repository;

import com.bycoders.apidemo.model.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long> {
  Loja findByNome(String nome);

}
