package com.blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @OneToMany
    @JoinColumn(name = "tema_id")
    private List<Postagem> postagens;

    public Tema() {
    }

    public Tema(Long id, String descricao, List<Postagem> postagens) {
        this.id = id;
        this.descricao = descricao;
        this.postagens = postagens;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }
}
