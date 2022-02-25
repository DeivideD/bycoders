package com.bycoders.apidemo.service;

import com.bycoders.apidemo.model.Loja;
import com.bycoders.apidemo.repository.LojaRepository;
import com.bycoders.apidemo.util.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojaService {

  @Autowired
  private LojaRepository lojaRepositor;

  public Loja findByNome(String nome){
    return lojaRepositor.findByNome(nome);
  }

  public Loja save(Loja loja){
    return lojaRepositor.save(loja);
  }
}
