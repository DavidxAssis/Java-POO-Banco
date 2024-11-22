import model.ContaBancaria;
import model.ContaCorrente;
import model.ContaPoupanca;
import model.Movimentacao;
import utils.DataUtil;

public class App {
    public static void main(String[] args) {
        
        ContaBancaria conta = new ContaCorrente("0001", "1777", 5, 1500.0);

        System.out.println("Saldo atual da conta é de R$" + conta.getSaldo());
        System.out.println();

        conta.depositar(200.0);
        System.out.println("Saldo atual da conta é de R$" + conta.getSaldo());
        System.out.println();

        conta.sacar(1000.0);
        System.out.println("Saldo atual da conta é de R$" + conta.getSaldo());
        System.out.println();

        ContaBancaria conta2 = new ContaPoupanca("0002", "1772", 2, 100.0);

        conta2.transferir(10.0, conta);
        System.out.println("Saldo atual da conta2 é de R$" + conta2.getSaldo());
        System.out.println();

        System.out.println("Saldo atual da conta é de R$" + conta.getSaldo());
        System.out.println(conta2.getDataAbertura());


        Movimentacao movimentacao = new Movimentacao("Saque", 1000.0);

        System.out.println(movimentacao);

        conta.ImprimirExtrato();
        System.out.println();
        System.out.println();
        conta2.ImprimirExtrato();
        
    }
}