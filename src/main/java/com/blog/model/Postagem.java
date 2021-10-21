package com.blog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "postagem")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis());

    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

    public Postagem() {
    }

    public Postagem(Long id, String titulo, String texto, Date data, Tema tema) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.data = data;
        this.tema = tema;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setDate(Date data) {
        this.data = data;
    }
}