package com.uepg.comp.eng.futebol_pagamentos.repository;

import com.uepg.comp.eng.futebol_pagamentos.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
}