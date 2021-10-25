package com.blog.service;

import com.blog.model.Usuario;
import com.blog.model.UsuarioLogin;
import com.blog.repository.UsuarioRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.nio.charset.Charset;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    // cadastrando um usuário
    public Usuario cadastrarUsuario(Usuario usuario) {
        // vamos trabalhar a senha encriptada apartir do BCryptPasswordEncoder da classe BasicSecurityConfig
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // encriptando a senha, que vai estar como atributo do usuário que eu estiver cadastrando
        String senhaEncoder = encoder.encode(usuario.getSenha());

        // settando essa senha encoded na senha do usuario
        usuario.setSenha(senhaEncoder);

        // salvando o usuário no banco de dados
        return usuarioRepository.save(usuario);
    }

    // fazendo login do usuário
    public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> usuarioLogin) {
        // vamos trabalhar a senha encriptada apartir do BCryptPasswordEncoder da classe BasicSecurityConfig
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Acessando o usuário que contém aquela senha à ser verificada pelo nome de usuário
        Optional<Usuario> usuario = usuarioRepository.findByUsuario(usuarioLogin.get().getUsuario());

        // Preciso verificar se o tive retorno de um usuário do banco, e verificar se a senha dele é igual à senha do usuário que veio para fazer login
        if (usuario.isPresent()) {

            if (encoder.matches(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {

                // string para gerar token
                String auth = usuarioLogin.get().getUsuario() + ":" + usuarioLogin.get().getSenha();

                // gerando o token
                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));

                // concatendo autorização + token
                String authHeader = "Basic " + new String(encodeAuth);

                // settando token e nome do usuarioLogin à ser retornado, já que o nome de usuário é mesmo já que passou em todas as verificações
                usuarioLogin.get().setToken(authHeader);
                usuarioLogin.get().setNome(usuario.get().getNome());

                return usuarioLogin;
            }
        }
        return null;
    }
}
