package com.bycoders.apidemo.util;

import com.bycoders.apidemo.importacao.ImportadorMovimentacao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class GeraCpfCnpjTest {
  @Autowired
  private ImportadorMovimentacao im;
  private GeraCpfCnpj geraCpfCnpj = new GeraCpfCnpj();

  @Test
  void cpf() {
    String novoPF = geraCpfCnpj.cpf(false);
    Assert.assertTrue(geraCpfCnpj.isCPF(novoPF));
  }

  @Test
  void cnpj() {
    String novoCNPJ = geraCpfCnpj.cnpj(false);
    Assert.assertTrue(geraCpfCnpj.isCNPJ(novoCNPJ));
  }

  @Test
  void isCPF() {
    String cpfValido = "98707566034";
    String cpfInvalido = "98707266034";
    Assert.assertTrue(geraCpfCnpj.isCPF(cpfValido));
    Assert.assertFalse(geraCpfCnpj.isCPF(cpfInvalido));
  }

  @Test
  void isCNPJ() {
    String cpfValido = "03206666000199";
    String cpfInvalido = "03206666000198";
    Assert.assertTrue(geraCpfCnpj.isCNPJ(cpfValido));
    Assert.assertFalse(geraCpfCnpj.isCNPJ(cpfInvalido));
  }

  @Test
  void ValidarTamanhoCpfCnpj() {
    Assert.assertTrue( geraCpfCnpj.cnpj(false).length() == 14);
    Assert.assertTrue( geraCpfCnpj.cpf(false).length() == 11);
  }

}