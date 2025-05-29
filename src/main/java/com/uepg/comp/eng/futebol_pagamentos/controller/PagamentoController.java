package com.uepg.comp.eng.futebol_pagamentos.controller;

import com.uepg.comp.eng.futebol_pagamentos.dto.PagamentoInputDTO;
import com.uepg.comp.eng.futebol_pagamentos.model.Pagamento;
import com.uepg.comp.eng.futebol_pagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/jogador/{codJogador}")
    public ResponseEntity<Pagamento> criarPagamento(@PathVariable Integer codJogador, @RequestBody PagamentoInputDTO pagamentoInput) {
        Pagamento pagamento = new Pagamento();
        pagamento.setAno(pagamentoInput.getAno());
        pagamento.setMes(pagamentoInput.getMes());
        pagamento.setValor(pagamentoInput.getValor());

        try {
            Pagamento novoPagamento = pagamentoService.criarPagamento(codJogador, pagamento);
            return new ResponseEntity<>(novoPagamento, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> listarTodosPagamentos() {
        List<Pagamento> pagamentos = pagamentoService.listarTodosPagamentos();
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> buscarPagamentoPorId(@PathVariable Integer id) {
        return pagamentoService.buscarPagamentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/jogador/{codJogador}")
    public ResponseEntity<List<Pagamento>> buscarPagamentosPorJogador(@PathVariable Integer codJogador) {
        List<Pagamento> pagamentos = pagamentoService.buscarPagamentosPorJogador(codJogador);
        if (pagamentos.isEmpty()) {
        }
        return ResponseEntity.ok(pagamentos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> atualizarPagamento(@PathVariable Integer id, @RequestBody PagamentoInputDTO pagamentoDetails) {
        Pagamento pagamento = new Pagamento();
        pagamento.setAno(pagamentoDetails.getAno());
        pagamento.setMes(pagamentoDetails.getMes());
        pagamento.setValor(pagamentoDetails.getValor());
        try {
            Pagamento pagamentoAtualizado = pagamentoService.atualizarPagamento(id, pagamento);
            return ResponseEntity.ok(pagamentoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPagamento(@PathVariable Integer id) {
        try {
            pagamentoService.deletarPagamento(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}