package com.bycoders.apidemo.repository;

import com.bycoders.apidemo.model.Representante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentanteRepository extends JpaRepository<Representante, Long> {
  Representante findByNome(String nome);

  Representante findByCPF(String cpf);

}
