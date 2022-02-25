package com.bycoders.apidemo.model;

import com.bycoders.apidemo.util.model.GenericEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "transacao")
public class Transacao extends GenericEntity {

  @Column
  private int tipo;

  @Column
  private String descricao;

  @Column
  private String natureza;

  @OneToMany(mappedBy = "transacao", fetch = FetchType.EAGER)
  private List<Movimentacao> movimentacoes;

  public int getTipo() {
    return tipo;
  }

  public void setTipo(int tipo) {
    this.tipo = tipo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getNatureza() {
    return natureza;
  }

  public void setNatureza(String natureza) {
    this.natureza = natureza;
  }

  public List<Movimentacao> getMovimentacoes() {
    return movimentacoes;
  }

  public void setMovimentacoes(List<Movimentacao> movimentacoes) {
    this.movimentacoes = movimentacoes;
  }
}
