package com.bycoders.apidemo.controller;


import com.bycoders.apidemo.model.Loja;
import com.bycoders.apidemo.model.MovimentacaoLoja;
import com.bycoders.apidemo.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lojas")
public class LojaController {

  @Autowired
  private LojaRepository lojaRepository;

  @GetMapping
  public ResponseEntity<List<Loja>> lojas(){
    List<Loja> lojas = lojaRepository.findAll();
    return new ResponseEntity<List<Loja>>(lojas, HttpStatus.OK);
  }
}
