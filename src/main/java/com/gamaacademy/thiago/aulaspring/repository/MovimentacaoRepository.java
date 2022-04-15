package com.gamaacademy.thiago.aulaspring.repository;

import com.gamaacademy.thiago.aulaspring.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
