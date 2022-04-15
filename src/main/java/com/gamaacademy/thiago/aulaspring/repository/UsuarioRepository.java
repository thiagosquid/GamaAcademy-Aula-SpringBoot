package com.gamaacademy.thiago.aulaspring.repository;

import com.gamaacademy.thiago.aulaspring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
