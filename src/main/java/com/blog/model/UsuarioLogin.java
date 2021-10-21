package com.blog.model;

public class UsuarioLogin {

    private String nome;
    private String usuario;
    private String senha;
    private String token;

    public UsuarioLogin() {
    }

    public UsuarioLogin(String nome, String usuario, String senha, String token) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.token = token;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
