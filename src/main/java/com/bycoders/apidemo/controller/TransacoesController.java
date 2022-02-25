package com.bycoders.apidemo.controller;

import com.bycoders.apidemo.data.TransacoesData;
import com.bycoders.apidemo.model.MovimentacaoLoja;
import com.bycoders.apidemo.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transacoes")
public class TransacoesController {


  @Autowired
  private TransacaoService transacaoService;


  @Autowired
  private TransacoesData transacoesData;

  @GetMapping
  public ResponseEntity<List<MovimentacaoLoja>> carregarTrasacoes(){
    List<MovimentacaoLoja> trasacoes = transacoesData.buscarTrasacoes();
    return new ResponseEntity<List<MovimentacaoLoja>>(trasacoes, HttpStatus.OK);
  }
}
