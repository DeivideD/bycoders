package com.bycoders.apidemo.service;

import com.bycoders.apidemo.model.MovimentacaoLoja;
import com.bycoders.apidemo.model.Transacao;
import com.bycoders.apidemo.repository.TransacaoRepository;
import com.bycoders.apidemo.util.exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {
  @Autowired
  private TransacaoRepository transacaoRepository;

  public Transacao findByTipo(int tipo){
    return transacaoRepository.findByTipo(tipo);
  }

  public Transacao save( Transacao transacao ){
    return transacaoRepository.save(transacao);
  }

  public List<Object[]> trasacoesPorLoja(){
    return transacaoRepository.trasacoesPorLoja();
  }

}
