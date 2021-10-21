package com.blog.controller;

import com.blog.model.Postagem;
import com.blog.repository.PostagemRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {
    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    public ResponseEntity<List<Postagem>> GetAll() {
        return ResponseEntity.ok(postagemRepository.findAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Postagem> getById(@PathVariable ("id") Long id) {
        return postagemRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable ("titulo") String titulo) {
        return ResponseEntity.ok(
                postagemRepository.findAllByTitulo(titulo)
        );
    }

    @GetMapping("/texto/{texto}")
    public ResponseEntity<List<Postagem>> getByTexto(@PathVariable ("texto") String texto) {
        return ResponseEntity.ok(
                postagemRepository.findAllByTexto(texto)
        );
    }

    @PostMapping("/criar")
    public ResponseEntity<Postagem> createPostagem(@RequestBody Postagem postagem) {
        return ResponseEntity.status(
                HttpStatus.CREATED
        ).body(
                postagemRepository.save(postagem)
        );
    }

    @PutMapping("/alterar")
    public ResponseEntity<Postagem> updatePostagem(@RequestBody Postagem postagem) {
        return ResponseEntity.status(
                HttpStatus.OK
        ).body(
                postagemRepository.save(postagem)
        );
    }
}
