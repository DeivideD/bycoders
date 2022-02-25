package com.bycoders.apidemo.model;

import com.bycoders.apidemo.util.model.GenericEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "loja")
public class Loja extends GenericEntity {

  @Column
  private String nome;

  @Column
  private String CNPJ;

  @ManyToOne
  @JoinColumn(name = "representante_id")
  private Representante representante;

  @Column
  private String endereco;

  @Column
  private String cidade;

  @Column
  private String estado;

  @OneToMany(mappedBy = "loja", fetch = FetchType.EAGER)
  private List<Movimentacao> movimentacoes;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Representante getRepresentante() {
    return representante;
  }

  public void setRepresentante(Representante representante) {
    this.representante = representante;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public List<Movimentacao> getMovimentacoes() {
    return movimentacoes;
  }

  public void setMovimentacoes(List<Movimentacao> movimentacoes) {
    this.movimentacoes = movimentacoes;
  }

  public String getCNPJ() {
    return CNPJ;
  }

  public void setCNPJ(String CNPJ) {
    this.CNPJ = CNPJ;
  }
}
