package com.bn.exercico4.controllers;

import com.bn.exercico4.models.AutorModel;
import com.bn.exercico4.services.AutorService;
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
        List<AutorModel> autor = autorService.findAll();
        return ResponseEntity.ok().body(autor);
    }

    @GetMapping("/{id}")
    public AutorModel buscarAutorPorId(@PathVariable Long id){
        return autorService.buscarAutorPorId(id);
    }

    @PostMapping
    public ResponseEntity<AutorModel> criarAutor(@RequestBody AutorModel autorModel){
        AutorModel autorCriado = autorService.criarAutor(autorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(autorModel.getId()).toUri();
        return ResponseEntity.created(uri).body(autorCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorModel> atualizarAutor(@PathVariable Long id, @RequestBody AutorModel autorModel){
        AutorModel autorAtualizado = autorService.atualizarAutor(id, autorModel);
        return ResponseEntity.ok(autorAtualizado);
    }

}
