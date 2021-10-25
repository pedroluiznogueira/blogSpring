package com.blog.service;

import com.blog.model.Usuario;
import com.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

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
}
