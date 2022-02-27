package com.bycoders.apidemo.service;

import com.bycoders.apidemo.model.Representante;
import com.bycoders.apidemo.repository.RepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepresentanteService {
  @Autowired
  private RepresentanteRepository representanteRepository;

  public Representante findByCPF(String cpf){
    return representanteRepository.findByCPF(cpf);
  }

  public Representante findByNome(String nome){
    return representanteRepository.findByNome(nome);
  }

  public Representante save(Representante representante){
    return representanteRepository.save(representante);
  }
  public List<Representante> findAll(){
    return representanteRepository.findAll();
  }
}
