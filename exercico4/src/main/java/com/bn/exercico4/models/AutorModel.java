package com.bn.exercico4.models;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity (name = "Autor")
@Table (name = "TBL_AUTOR")
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "nome_autor")
    private String nome;

    @Column(name = "nacionalidade_autor")
    private String nacionalidade;

    @Column(name = "data_nascimento_autor")
    private LocalDate dataNascimento;

    public AutorModel(){

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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
