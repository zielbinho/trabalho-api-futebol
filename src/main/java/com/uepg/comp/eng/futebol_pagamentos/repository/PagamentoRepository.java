package com.uepg.comp.eng.futebol_pagamentos.repository;

import com.uepg.comp.eng.futebol_pagamentos.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    List<Pagamento> findByJogadorCodJogador(Integer codJogador);
    List<Pagamento> findByAnoAndMes(Short ano, Byte mes);
}