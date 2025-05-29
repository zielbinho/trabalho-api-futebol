package com.uepg.comp.eng.futebol_pagamentos.service;

import com.uepg.comp.eng.futebol_pagamentos.model.Jogador;
import com.uepg.comp.eng.futebol_pagamentos.model.Pagamento;
import com.uepg.comp.eng.futebol_pagamentos.repository.JogadorRepository;
import com.uepg.comp.eng.futebol_pagamentos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @Transactional
    public Pagamento criarPagamento(Integer codJogador, Pagamento pagamento) {
        Jogador jogador = jogadorRepository.findById(codJogador)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado com id: " + codJogador));
        pagamento.setJogador(jogador);
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> listarTodosPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> buscarPagamentoPorId(Integer id) {
        return pagamentoRepository.findById(id);
    }

    public List<Pagamento> buscarPagamentosPorJogador(Integer codJogador) {
        return pagamentoRepository.findByJogadorCodJogador(codJogador);
    }

    @Transactional
    public Pagamento atualizarPagamento(Integer id, Pagamento pagamentoDetails) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com id: " + id));

        pagamento.setAno(pagamentoDetails.getAno());
        pagamento.setMes(pagamentoDetails.getMes());
        pagamento.setValor(pagamentoDetails.getValor());

        return pagamentoRepository.save(pagamento);
    }

    @Transactional
    public void deletarPagamento(Integer id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado com id: " + id));
        pagamentoRepository.delete(pagamento);
    }
}