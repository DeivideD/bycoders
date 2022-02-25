package com.bycoders.apidemo.importacao;

import com.bycoders.apidemo.model.Loja;
import com.bycoders.apidemo.model.Representante;
import com.bycoders.apidemo.model.Transacao;
import com.bycoders.apidemo.service.LojaService;
import com.bycoders.apidemo.service.RepresentanteService;
import com.bycoders.apidemo.service.TransacaoService;
import com.bycoders.apidemo.util.GeraCpfCnpj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Configurable
public class GerardorDados {

  @Autowired
  private TransacaoService transacaoService;

  @Autowired
  private RepresentanteService representanteService;

  @Autowired
  private LojaService lojaService;


  public Loja gerarLojas(String nomeLoja, String nomeRepresentante ){
    GeraCpfCnpj gerador = new GeraCpfCnpj();
    Loja novaLoja = new Loja();

    novaLoja.setNome(nomeLoja);
    novaLoja.setCNPJ(gerador.cnpj(false));
    novaLoja.setEndereco(gerarEndereco());
    novaLoja.setCidade(gerarCidade());
    novaLoja.setEstado(gerarEstado());
    novaLoja.setRepresentante(verificarRepresentante(nomeRepresentante));
    return lojaService.save(novaLoja);

  }
  public Representante gerarRepresentante(String nome ){
      GeraCpfCnpj gerador = new GeraCpfCnpj();
      Representante novoRepresentante = new Representante();

      novoRepresentante.setNome(nome);
      novoRepresentante.setCPF(gerador.cpf(false));
      return representanteService.save(novoRepresentante);
  }

  public String gerarEndereco() {
    Random random = new Random();
    int aleatorio = random.nextInt(10);
    switch (aleatorio) {
      case 1:
        return "Rua Paulo Terceiro";
      case 2:
        return "Rua da desalmadas";
      case 3:
        return "Rua nossa senhora aparecida";
      case 4:
        return "Rua campo largo";
      case 5:
        return "Rua Palmares";
      case 6:
        return "Rua Projetada IV ";
      case 7:
        return "Rua sao jose";
      case 8:
        return "Rua das solteiras";
      case 9:
        return "Rua Santo antonio";
      case 10:
        return "Rua sao benedito";
    }
    return "Rua default";
  }

  public String gerarCidade( ) {
    Random random = new Random();
    int aleatorio = random.nextInt(10);
    switch (aleatorio) {
      case 1:
        return "Crato";
      case 2:
        return "Juazeiro";
      case 3:
        return "Leblom";
      case 4:
        return "Jardins";
      case 5:
        return "Gramado";
      case 6:
        return "Ilheus";
      case 7:
        return "Paracuru";
      case 8:
        return "Lagoinha";
      case 9:
        return "Canoa quebrada";
      case 10:
        return "Amontada";
    }
    return "Viçosa";
  }

  public String gerarEstado( ) {
    Random random = new Random();
    int aleatorio = random.nextInt(10);
    switch (aleatorio) {
      case 1:
        return "Ceara";
      case 2:
        return "Sao Paulo";
      case 3:
        return "Rio de Janeiro";
      case 4:
        return "Rio Grande do Sul";
      case 5:
        return "Goias";
      case 6:
        return "Bahia";
      case 7:
        return "Maranhão";
      case 8:
        return "Brasilia";
      case 9:
        return "Piaui";
      case 10:
        return "Amazonas";
    }
    return "Amazonas";
  }

  public Transacao gerarTransacoes(String tipo ){
    Transacao transacao = new Transacao();
    transacao.setTipo(Integer.parseInt(tipo));

    switch (tipo) {
      case "1":
        transacao.setDescricao("Débito");
        transacao.setNatureza("Entrada");
        break;
      case "2":
        transacao.setDescricao("Boleto");
        transacao.setNatureza("Saída");
        break;
      case "3":
        transacao.setDescricao("Financiamento");
        transacao.setNatureza("Saída");
        break;
      case "4":
        transacao.setDescricao("Crédito");
        transacao.setNatureza("Entrada");
        break;
      case "5":
        transacao.setDescricao("Recebimento Empréstimo");
        transacao.setNatureza("Entrada");
        break;
      case "6":
        transacao.setDescricao("Vendas");
        transacao.setNatureza("Entrada");
        break;
      case "7":
        transacao.setDescricao("Recebimento TED");
        transacao.setNatureza("Entrada");
        break;
      case "8":
        transacao.setDescricao("Recebimento DOC");
        transacao.setNatureza("Entrada");
        break;
      case "9":
        transacao.setDescricao("Aluguel");
        transacao.setNatureza("Saída");
        break;
    }
    return transacaoService.save(transacao);
  }

  private Representante verificarRepresentante(String nome){
    Representante representante = representanteService.findByNome(nome);
    if (representante == null) {
      return gerarRepresentante(nome);
    }
    return representante;
  }
}
