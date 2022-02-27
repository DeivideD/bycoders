package com.bycoders.apidemo.importacao;

import com.bycoders.apidemo.model.Loja;
import com.bycoders.apidemo.model.Movimentacao;
import com.bycoders.apidemo.model.Representante;
import com.bycoders.apidemo.model.Transacao;
import com.bycoders.apidemo.service.LojaService;
import com.bycoders.apidemo.service.RepresentanteService;
import com.bycoders.apidemo.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;


@Service
@Configurable
public class ImportadorMovimentacao {

  @Autowired
  private TransacaoService transacaoService;

  @Autowired
  private LojaService lojaService;

  @Autowired
  private GerardorDados gerardorDados;

  @Autowired
  private RepresentanteService representanteService;

  public List<Movimentacao> carregarArquivoCNAB(MultipartFile arquivo) {


    Movimentacao movimentacao = new Movimentacao();
    List<Movimentacao> movimentacoes = new ArrayList();

    try {
      InputStream inputStream = arquivo.getInputStream();

      Scanner leitor = new Scanner(inputStream);
      //variavel que armazenara as linhas do arquivo
      String linhasDoArquivo;

      //percorre todo o arquivo
      while (leitor.hasNext()) {
        linhasDoArquivo = leitor.nextLine();
         movimentacao.setTransacao(parseTransaction(Integer.parseInt(linhasDoArquivo.substring(0,1))));
         movimentacao.setData(parserData(linhasDoArquivo.substring(1,9), "yyyy-MM-dd"));
         movimentacao.setValor(parseValor(linhasDoArquivo.substring(9,19)));
         movimentacao.setCPF(linhasDoArquivo.substring(19,30));
         movimentacao.setCartao(linhasDoArquivo.substring(30,42));
         movimentacao.setHora(parseHora(linhasDoArquivo.substring(42,48)));
         movimentacao.setLoja(parseLoja(linhasDoArquivo.substring(62,linhasDoArquivo.length()),linhasDoArquivo.substring(48,62)));
        movimentacoes.add(movimentacao);
        movimentacao = new Movimentacao();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return movimentacoes;
  }

  public Date parserData(String dateParser, String format) {
    Date date = new Date();
    System.out.println(format);
    if (dateParser == null || dateParser.equals("")) {
      return null;
    }
    try {
      SimpleDateFormat formatter = new SimpleDateFormat(format);
      date = formatter.parse(dateParser.substring(0,4)+ "-" + dateParser.substring(4,6)+ "-" + dateParser.substring(6,8));
    } catch (ParseException e) {
      System.out.println(e.getMessage());
    }
    return date;
  }

  public Double parseValor(String valor) {
    Double valorParseado = Double.parseDouble(valor) / 100.00;
    return valorParseado;
  }

  public String parseHora(String hora) {
    if (hora == null || hora.equals("")) {
      return "";
    }
    return hora.substring(0,2) + ":" +  hora.substring(2,4) + ":" + hora.substring(4,6);
  }

  public Transacao parseTransaction(int tipo) {
    Transacao transacao = transacaoService.findByTipo(tipo);
    if(transacao == null){
      return gerardorDados.gerarTransacoes( Integer.toString(tipo));
    }
    return transacao;
  }

  public String parseCPF(String cpf) {
    Representante representante = new Representante();
    return representante.getCPF();
  }

  public Loja parseLoja(String nomeLoja, String nomeRepresentante) {
    Loja loja = lojaService.findByNome(nomeLoja);
      if (loja == null) {
        return gerardorDados.gerarLojas(nomeLoja, nomeRepresentante);
      }
    return loja;
  }

}
