package com.blog.controller;

import com.blog.model.Postagem;
import com.blog.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {
    @Autowired
    private PostagemRepository repository;

    @GetMapping
    public ResponseEntity<List<Postagem>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> GetById(@PathVariable Long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
                                    .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("texto/{texto}")
    public ResponseEntity<List<Postagem>> getByTexto(@PathVariable String texto){
        return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
    }
}
