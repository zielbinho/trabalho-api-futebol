package com.uepg.comp.eng.futebol_pagamentos.dto;

import java.math.BigDecimal;

public class PagamentoInputDTO {
    private Short ano;
    private Byte mes;
    private BigDecimal valor;

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public Byte getMes() {
        return mes;
    }

    public void setMes(Byte mes) {
        this.mes = mes;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}