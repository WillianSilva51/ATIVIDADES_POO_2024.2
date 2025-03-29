package br.ufc.quixada.gestao.model;

import br.ufc.quixada.gestao.contrato.IRHService.Tipo;

public abstract class Funcionario implements Comparable<Funcionario> {
    private String nome;
    private String cpf;
    private double lucro;
    protected Tipo tipo;
    protected int totalDiarias;

    public Funcionario(String cpf, String nome) {
        this.nome = nome;
        this.cpf = cpf;

        setTipo();
    }

    protected abstract void setTipo();

    public abstract double calcularSalarioBase();

    public abstract boolean solicitarDiaria();

    public abstract boolean verificarValidade();

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getSalarioBase() {
        return calcularSalarioBase();
    }

    public double calcularSalario() {
        return getSalarioBase() + (totalDiarias * 100) + lucro;
    }

    public void novoMes() {
        totalDiarias = 0;
        lucro = 0;
    }

    @Override
    public int compareTo(Funcionario func) {
        return this.nome.compareTo(func.nome);
    }
}