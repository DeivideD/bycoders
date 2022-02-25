package com.bycoders.apidemo.model;

import java.io.Serializable;
import java.util.Objects;

public class MovimentacaoLoja implements Serializable {

  private String transacao;
  private String loja;
  private String natureza;
  private Double valor;


  public String getTransacao() {
    return transacao;
  }

  public void setTransacao(String transacao) {
    this.transacao = transacao;
  }

  public String getLoja() {
    return loja;
  }

  public void setLoja(String loja) {
    this.loja = loja;
  }

  public String getNatureza() {
    return natureza;
  }

  public void setNatureza(String natureza) {
    this.natureza = natureza;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MovimentacaoLoja that = (MovimentacaoLoja) o;
    return Objects.equals(transacao, that.transacao) && Objects.equals(loja, that.loja) && Objects.equals(natureza, that.natureza) && Objects.equals(valor, that.valor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transacao, loja, natureza, valor);
  }
}
