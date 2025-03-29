/**
 * @author bruno
 *
 */

public class Conta {
    private int numero;
    private double saldo;
    private double limite;
    private double extrato[];
    private int operacoes;

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
        operacoes = 0;
        extrato = new double[10];
        limite = 100;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo + limite;
    }

    public double getLimite() {
        return limite;
    }

    public boolean sacar(double valor) {
        if (valor < 0 || valor > getSaldo())
            return false;

        if (valor > saldo) {
            limite -= (valor - saldo);
            saldo = 0;
        } else {
            saldo -= valor;
        }

        extrato[operacoes++] = -valor;

        return true;
    }

    public boolean depositar(double valor) {
        if (valor < 0)
            return false;

        if (limite < 100) {
            if (valor > 100 - limite) {
                saldo += (valor - (100 - limite));
                limite = 100;
            } else {
                limite += valor;
            }
        } else {
            saldo += valor;
        }

        extrato[operacoes++] = valor;

        return true;
    }

    public boolean transferir(Conta destino, double valor) {
        if (valor < 0 || valor > getSaldo())
            return false;

        destino.depositar(valor);

        if (valor > saldo) {
            limite -= (valor - saldo);
            saldo = 0;
        } else {
            saldo -= valor;
        }

        extrato[operacoes++] = -valor;

        return true;
    }

    public double[] verExtrato() {
        return extrato;
    }

    @Override
    public String toString() {
        return "Conta{" + "numero=" + numero + ", saldo=" + saldo + ", limite=" + limite + "}";
    }
}