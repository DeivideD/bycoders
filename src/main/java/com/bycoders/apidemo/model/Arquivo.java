package com.bycoders.apidemo.model;

import com.bycoders.apidemo.util.model.GenericEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "Arquivos")
public class Arquivo extends GenericEntity {

  @Column
  private String nome;

  @Column
  private String responsavel;

  @Column
  private Date dataHora;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getResponsavel() {
    return responsavel;
  }

  public void setResponsavel(String responsavel) {
    this.responsavel = responsavel;
  }

  public Date getDataHora() {
    return dataHora;
  }

  public void setDataHora(Date dataHora) {
    this.dataHora = dataHora;
  }
}
