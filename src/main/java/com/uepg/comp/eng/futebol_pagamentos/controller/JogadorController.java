package com.uepg.comp.eng.futebol_pagamentos.controller;

import com.uepg.comp.eng.futebol_pagamentos.model.Jogador;
import com.uepg.comp.eng.futebol_pagamentos.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Jogador> criarJogador(@RequestBody Jogador jogador) {
        Jogador novoJogador = jogadorService.criarJogador(jogador);
        return new ResponseEntity<>(novoJogador, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> listarTodosJogadores() {
        List<Jogador> jogadores = jogadorService.listarTodosJogadores();
        return ResponseEntity.ok(jogadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarJogadorPorId(@PathVariable Integer id) {
        return jogadorService.buscarJogadorPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizarJogador(@PathVariable Integer id, @RequestBody Jogador jogadorDetails) {
        try {
            Jogador jogadorAtualizado = jogadorService.atualizarJogador(id, jogadorDetails);
            return ResponseEntity.ok(jogadorAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogador(@PathVariable Integer id) {
        try {
            jogadorService.deletarJogador(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
