package com.bn.exercico4.services;

import com.bn.exercico4.models.AutorModel;
import com.bn.exercico4.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<AutorModel> findAll(){
        return autorRepository.findAll();
    }

    public AutorModel criarAutor(AutorModel autorModel){
        return autorRepository.save(autorModel);
    }

    public void deletarAutor(Long id){
        autorRepository.deleteById(id);
    }

    public AutorModel buscarAutorPotId(Long id){
        return autorRepository.findById(id).get();
    }

    public AutorModel atualizarAutor(Long id, AutorModel autorModel){
        AutorModel newAutorModel = autorRepository.findById(id).get();
        return autorRepository.save(autorModel);
    }

}
