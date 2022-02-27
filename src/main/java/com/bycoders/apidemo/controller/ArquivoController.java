package com.bycoders.apidemo.controller;


import com.bycoders.apidemo.model.Movimentacao;
import com.bycoders.apidemo.service.MovimentacaoService;
import com.bycoders.apidemo.importacao.ImportadorMovimentacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

 @Autowired
 private MovimentacaoService movimentacaoService;

@Autowired
  private ImportadorMovimentacao importadorMovimentacao;

  @PostMapping("/carregar")
  public ResponseEntity<?>  uploadArquivo(@RequestParam MultipartFile arquivo){
    List<Movimentacao> movimentcoes = importadorMovimentacao.carregarArquivoCNAB(arquivo);

    for( Movimentacao movimentacao : movimentcoes ){
     movimentacaoService.save(movimentacao);
    }
    return new ResponseEntity<>("Importação Realizada", HttpStatus.CREATED);
  }

}
