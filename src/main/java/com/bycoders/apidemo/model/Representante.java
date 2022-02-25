package com.bycoders.apidemo.model;

import com.bycoders.apidemo.util.model.GenericEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "representante")
public class Representante extends GenericEntity {

  @Column
  private String nome;

  @Column
  private String CPF;

  @OneToMany(mappedBy = "representante", fetch = FetchType.EAGER)
  private List<Loja> lojas;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String CPF) {
    this.CPF = CPF;
  }

  public List<Loja> getLojas() {
    return lojas;
  }

  public void setLojas(List<Loja> lojas) {
    this.lojas = lojas;
  }
}
