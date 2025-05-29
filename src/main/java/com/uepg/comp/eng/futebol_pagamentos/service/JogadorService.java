package com.uepg.comp.eng.futebol_pagamentos.service;

import com.uepg.comp.eng.futebol_pagamentos.model.Jogador;
import com.uepg.comp.eng.futebol_pagamentos.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Transactional
    public Jogador criarJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarTodosJogadores() {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> buscarJogadorPorId(Integer id) {
        return jogadorRepository.findById(id);
    }

    @Transactional
    public Jogador atualizarJogador(Integer id, Jogador jogadorDetails) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado com id: " + id));

        jogador.setNome(jogadorDetails.getNome());
        jogador.setEmail(jogadorDetails.getEmail());
        jogador.setDataNasc(jogadorDetails.getDataNasc());

        return jogadorRepository.save(jogador);
    }

    @Transactional
    public void deletarJogador(Integer id) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado com id: " + id));
        jogadorRepository.delete(jogador);
    }
}