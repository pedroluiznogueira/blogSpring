package com.blog.repository;

import com.blog.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemaRepository extends JpaRepository<Tema, Long> {

    public List<Tema> findAllByDescricaoContaining(String descricao);
}
