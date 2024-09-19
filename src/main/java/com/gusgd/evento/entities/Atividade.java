package com.gusgd.evento.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

@Entity
@Table(name = "tb_atividade")
public class Atividade {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String Descricao;
  private Double preco;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private Categoria categoria;

  @OneToMany(mappedBy = "atividade")
  private final List<Bloco> blocos = new ArrayList<>();

  @ManyToMany
  @JoinTable(
      name = "tb_atividade_participante",
      joinColumns = @JoinColumn(name = "atividade_id"),
      inverseJoinColumns = @JoinColumn(name = "participante_id")
  )
  private Set<Participante> participantes = new HashSet<>();

  public Atividade() {}

  public Atividade(Long id, String nome, Double preco) {
    this.id = id;
    this.nome = nome;
    this.preco = preco;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public List<Bloco> getBlocos() {
    return blocos;
  }

  public Set<Participante> getParticipantes() {
    return participantes;
  }

  public void setParticipantes(Set<Participante> participantes) {
    this.participantes = participantes;
  }

  public String getDescricao() {
    return Descricao;
  }

  public void setDescricao(String descricao) {
    Descricao = descricao;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }
}