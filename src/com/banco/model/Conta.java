package com.banco.model;

import com.banco.interfaces.IConta;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected String senha;
    protected List<Operacao> transacoes; // Lista de transações

    public Conta(Cliente cliente, String senha) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.senha = senha;
        this.transacoes = new ArrayList<>(); // Inicializa a lista de transações
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque!");
            return;
        }
        saldo -= valor;
        transacoes.add(new Operacao("Saque", -valor)); // Registra a transação
        System.out.println("Saque realizado com sucesso!");
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        transacoes.add(new Operacao("Depósito", valor)); // Registra a transação
        System.out.println("Depósito realizado com sucesso!");
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência!");
            return;
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
        transacoes.add(new Operacao("Transferência enviada", -valor)); // Registra a transação
        ((Conta) contaDestino).transacoes.add(new Operacao("Transferência recebida", valor)); // Registra no destino
        System.out.println("Transferência realizada com sucesso!");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato da Conta ===");
        imprimirInfosComuns();
        System.out.println("\nHistórico de Transações:");
        for (Operacao operacao : transacoes) {
            System.out.println(operacao);
        }
        System.out.println("=======================");
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }

    public Cliente getCliente() {
        return cliente;
    }
}