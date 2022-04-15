package com.gamaacademy.thiago.aulaspring.controller;

import com.gamaacademy.thiago.aulaspring.model.Movimentacao;
import com.gamaacademy.thiago.aulaspring.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("movimentacoes")
@CrossOrigin("*")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> getById(@PathVariable Integer id) {
        Movimentacao movimentacao = movimentacaoService.findById(id);
        return ResponseEntity.ok().body(movimentacao);
    }

    @GetMapping
    public ResponseEntity<List<Movimentacao>> getAll() {
        List<Movimentacao> movimentacoes = movimentacaoService.findAll();
        return ResponseEntity.ok().body(movimentacoes);
    }

    @PostMapping
    public ResponseEntity<Movimentacao> post(@RequestBody Movimentacao movimentacao) {
        Movimentacao movimentacaoCriada = movimentacaoService.create(movimentacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(movimentacaoCriada.getId()).toUri();
        return ResponseEntity.status(HttpStatus.GONE).body(movimentacaoCriada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimentacao> put(@PathVariable Integer id, @RequestBody Movimentacao movimentacao) {
        Movimentacao novaMovimentacao = movimentacaoService.update(id, movimentacao);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(novaMovimentacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        movimentacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
