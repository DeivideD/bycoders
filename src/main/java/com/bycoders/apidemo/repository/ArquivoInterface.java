package com.bycoders.apidemo.repository;

import com.bycoders.apidemo.model.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoInterface extends JpaRepository<Arquivo, Long> {

  Arquivo findById(long id);

}
