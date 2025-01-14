package model;

import java.util.Date;

import utils.DataUtil;

public class ContaCorrente extends ContaBancaria {
    public ContaCorrente(String agencia, String conta, Integer digito, Double saldoInicial) {
        super(agencia, conta, digito, saldoInicial);
    }

    @Override
    public void ImprimirExtrato() {
        System.out.println("**********************************");
        System.out.println("********Extrato Corrente**********");
        System.out.println("**********************************");
        System.out.println();

        System.out.println("Gerado em: " + DataUtil.converterDateParaDataEHora(new Date()));
        System.out.println();

        for (Movimentacao movimentacao : this.movimentacoes) {
            System.out.println(movimentacao);
        }
        System.out.println("**********************************");
        System.out.println("**********************************");
        System.out.println("**********************************");
    }    
}
