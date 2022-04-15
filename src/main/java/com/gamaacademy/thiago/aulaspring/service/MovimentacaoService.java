package com.gamaacademy.thiago.aulaspring.service;

import com.gamaacademy.thiago.aulaspring.model.Movimentacao;
import com.gamaacademy.thiago.aulaspring.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Movimentacao findById(Integer id) {
        Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
        return movimentacao.orElse(null);
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public Movimentacao update(Integer id, Movimentacao movimentacao) {
        Movimentacao novaMovimentacao = findById(id);
        novaMovimentacao.setCartao(movimentacao.getCartao());
        novaMovimentacao.setData(movimentacao.getData());
        novaMovimentacao.setValor(movimentacao.getValor());
        return movimentacaoRepository.save(novaMovimentacao);
    }

    public Movimentacao create(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public void delete(Integer id) {
        findById(id);
        movimentacaoRepository.deleteById(id);
    }

}
