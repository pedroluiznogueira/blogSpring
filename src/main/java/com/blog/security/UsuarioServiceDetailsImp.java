package com.blog.security;

import com.blog.model.Usuario;
import com.blog.repository.UsuarioRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceDetailsImp implements UserDetailsService {

    // preciso persistir o nome de usuario e a senha, verificar ou salvar
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Usuario> usuario = usuarioRepository.findByUsuario(username);
        usuario
                .orElseThrow(
                        () -> new UsernameNotFoundException(username + "not found")
                );
        return usuario.map(UsuarioDetailsImp::new).get();
    }

}
