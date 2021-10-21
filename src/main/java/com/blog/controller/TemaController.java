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

//    @GetMapping
//
//    @GetMapping
//
//    @PostMapping
//
//    @PutMapping
//
//    @DeleteMapping
}
