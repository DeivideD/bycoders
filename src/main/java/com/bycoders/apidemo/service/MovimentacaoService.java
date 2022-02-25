package com.bycoders.apidemo.service;

import com.bycoders.apidemo.model.Movimentacao;
import com.bycoders.apidemo.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {
  @Autowired
  private MovimentacaoRepository movimentacaoRepository;

  public Movimentacao save(Movimentacao mov){
    Movimentacao novaMovimentacao = movimentacaoRepository.save(mov);
    return novaMovimentacao;
  }
}
