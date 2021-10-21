package com.blog.controller;

import com.blog.model.Tema;
import com.blog.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")
public class TemaController {

    @Autowired
    private TemaRepository temaRepository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll() {
        return ResponseEntity.ok(
                temaRepository.findAll()
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Tema> getById(@PathVariable ("id") Long id) {
        return temaRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{descricao}")
    public ResponseEntity<List<Tema>> getByDescricao(@PathVariable ("descricao") String descricao) {
        return ResponseEntity.ok(
                temaRepository.findAllByDescricaoContainingIgnoreCase(descricao)
        );
    }

    @PostMapping("/criar")
    public ResponseEntity<Tema> createTema(@RequestBody Tema tema) {
        return ResponseEntity.status(
                HttpStatus.CREATED
        ).body(
                temaRepository.save(tema)
        );
    }

    @PutMapping("/alterar")
    public ResponseEntity<Tema> updateTema(@RequestBody Tema tema) {
        return ResponseEntity.status(
                HttpStatus.OK
        ).body(
                temaRepository.save(tema)
        );
    }

    @DeleteMapping("deletar/{id}")
    public void deleteTema(@PathVariable ("id") Long id) {
        temaRepository.deleteById(id);
    }
}
