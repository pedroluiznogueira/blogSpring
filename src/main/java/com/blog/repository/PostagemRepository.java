package com.blog.repository;

import com.blog.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    public List<Postagem> findAllByTitulo(String titulo);

    public List<Postagem> findAllByTexto(String texto);
}
