package br.ufc.quixada.gestao.model;

import br.ufc.quixada.gestao.contrato.IRHService.Tipo;

public class Terceirizado extends Funcionario {
    private boolean insalubre;

    public Terceirizado(String cpf, String nome, boolean insalubre) {
        super(cpf, nome);
        this.insalubre = insalubre;
    }

    @Override
    public boolean solicitarDiaria() {
        return false;
    }

    @Override
    public double calcularSalarioBase() {
        return insalubre ? 1500 : 1000;
    }

    @Override
    protected void setTipo() {
        tipo = Tipo.TERC;
    }

    @Override
    public boolean verificarValidade() {
        return true;
    }
}