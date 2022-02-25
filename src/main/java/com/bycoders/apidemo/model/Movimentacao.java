package com.bycoders.apidemo.model;

import com.bycoders.apidemo.util.model.GenericEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "movimentacao")
public class Movimentacao extends GenericEntity {

  @ManyToOne
  @JoinColumn(name = "transacao_id")
  private Transacao transacao;

  @Column
  @Temporal(TemporalType.DATE)
  private Date data;

  @Column
  private Double valor;

  @Column
  private String CPF;

  @Column
  private String cartao;

  @Column
  private String hora;

  @ManyToOne
  @JoinColumn(name = "loja_id")
  private Loja loja;


  public Transacao getTransacao() {
    return transacao;
  }

  public void setTransacao(Transacao transacao) {
    this.transacao = transacao;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  public String getCartao() {
    return cartao;
  }

  public void setCartao(String cartao) {
    this.cartao = cartao;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public Loja getLoja() {
    return loja;
  }

  public void setLoja(Loja loja) {
    this.loja = loja;
  }
}
