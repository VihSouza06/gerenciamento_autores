package com.bn.exercico4.controllers;

import com.bn.exercico4.models.AutorModel;
import com.bn.exercico4.services.AutorService;
import org.hibernate.boot.internal.Abstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorModel>> findAll(){
        List<AutorModel> requeste = autorService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<AutorModel> criarAutor(@RequestBody AutorModel autorModel){
        AutorModel requeste = autorService.criarAutor(autorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(autorModel.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public AutorModel buscarAutorPorId(@PathVariable Long id){
        return autorService.buscarAutorPotId(id);
    }

    @PutMapping("/{id}")
    public AutorModel atualizarAutor(@PathVariable Long id, AutorModel autorModel){
        return autorService.atualizarAutor(id, autorModel);
    }

}
