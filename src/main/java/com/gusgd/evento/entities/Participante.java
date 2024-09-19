package com.gusgd.evento.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_participante")
public class Participante {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;
  private String email;

  @ManyToMany(mappedBy = "participantes")
  private Set<Atividade> atividades = new HashSet<>();

  public Participante() {
  }

  public Participante(Integer id, String nome, String email, Set<Atividade> atividades) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.atividades = atividades;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Atividade> getAtividades() {
    return atividades;
  }

  public void setAtividades(Set<Atividade> atividades) {
    this.atividades = atividades;
  }
}
