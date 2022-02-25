package com.bycoders.apidemo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lojas")
public class LojaController {

  @GetMapping("/lojas")
  public void lojas(){

  }

}
