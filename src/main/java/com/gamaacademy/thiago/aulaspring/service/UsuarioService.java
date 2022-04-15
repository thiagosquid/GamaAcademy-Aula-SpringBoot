package com.gamaacademy.thiago.aulaspring.service;

import com.gamaacademy.thiago.aulaspring.model.Usuario;
import com.gamaacademy.thiago.aulaspring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario update(Integer id, Usuario usuario) {
        Usuario novoUsuario = findById(id);
        novoUsuario.setNome(usuario.getNome());
        novoUsuario.setSobrenome(usuario.getSobrenome());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setSenha(usuario.getSenha());
        return usuarioRepository.save(novoUsuario);
    }

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(Integer id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }
}
