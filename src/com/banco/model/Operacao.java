package com.banco.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operacao {
    private String tipo;
    private double valor;
    private LocalDateTime dataHora;

    public Operacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("%s | %s | Valor: R$ %.2f", 
            dataHora.format(formatter), tipo, valor);
    }
}