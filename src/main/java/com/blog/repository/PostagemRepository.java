package com.blog.repository;

import com.blog.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    // Consulta por titulo
    public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);

    // Consulta por texto
    public List<Postagem> findAllByTextoContainingIgnoreCase(String texto);

}
