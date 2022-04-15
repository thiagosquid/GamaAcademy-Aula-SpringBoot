package com.gamaacademy.thiago.aulaspring.controller;

import com.gamaacademy.thiago.aulaspring.model.Usuario;
import com.gamaacademy.thiago.aulaspring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
        Usuario usuarioCriado = usuarioService.create(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuarioCriado.getId()).toUri();
        return ResponseEntity.status(HttpStatus.GONE).body(usuarioCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> put(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.update(id, usuario);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(novoUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
