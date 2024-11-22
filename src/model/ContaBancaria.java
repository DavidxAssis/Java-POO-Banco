package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public abstract class ContaBancaria {
    //#region Atributos
    protected String agencia;
    protected String conta;
    protected Integer digito;
    protected Double saldo;
    protected Date dataAbertura;
    protected ArrayList<Movimentacao> movimentacoes;
    protected Double VALOR_MINIMO_DEPOSITO = 10.0;
    //#endregion

    //#region Construtores
    public ContaBancaria(String agencia, String conta, Integer digito, Double saldoInicial) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldoInicial;
        this.dataAbertura = new Date();

        this.movimentacoes = new ArrayList<Movimentacao>();

        Movimentacao movimentacao = new Movimentacao("Abertura de conta", saldoInicial);

        this.movimentacoes.add(movimentacao);
    }
    //#endregion

    //#region Getters e Setters
    public String getAgencia() {
        return agencia;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getConta() {
        return conta;
    }
    public void setConta(String conta) {
        this.conta = conta;
    }
    public Integer getDigito() {
        return digito;
    }
    public void setDigito(Integer digito) {
        this.digito = digito;
    }
    public Double getSaldo() {
        return saldo;
    }
    public Date getDataAbertura() {
        return dataAbertura;
    }
    //#endregion
    
    //#region Metodos
    public void depositar(Double valor){
        if(valor < VALOR_MINIMO_DEPOSITO){
            throw new InputMismatchException("O calor minimo para deposito é R$" + VALOR_MINIMO_DEPOSITO);
            
        }
        
        this.saldo += valor;

        Movimentacao movimentacao = new Movimentacao("Deposito", valor);
        this.movimentacoes.add(movimentacao);
    }

    public Double sacar(Double valor){

        if (valor>this.saldo) {
            throw new InputMismatchException("O saldo é insuficiente" );
        }

        this.saldo -= valor;

        Movimentacao movimentacao = new Movimentacao("Saque", valor);
        this.movimentacoes.add(movimentacao);

        return valor;
    }

    public void transferir(Double valor, ContaBancaria contaDestino){

        this.sacar(valor);

        contaDestino.depositar(valor);
    }
    //#endregion

    public abstract void ImprimirExtrato();
}
