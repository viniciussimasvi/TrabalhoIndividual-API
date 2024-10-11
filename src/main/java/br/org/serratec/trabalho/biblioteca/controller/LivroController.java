package br.org.serratec.trabalho.biblioteca.controller;

import br.org.serratec.trabalho.biblioteca.domain.Livro;
import br.org.serratec.trabalho.biblioteca.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<Livro>> listar(){
        return ResponseEntity.ok(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscar(@PathVariable Long id){
        Optional<Livro> livroOpt = livroRepository.findById(id);
        if(livroOpt.isPresent()){
            return ResponseEntity.ok(livroOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro inserir (@Valid @RequestBody Livro livro){
        livroRepository.save(livro);
        return livro;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @Valid @RequestBody Livro livro){
        if (!livroRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        livro.setId(id);
        return ResponseEntity.ok(livroRepository.save(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        if (!livroRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
















}
