package br.ufc.quixada.gestao.model;

import br.ufc.quixada.gestao.contrato.IRHService.Tipo;

public class STA extends Funcionario {
    private int nivel;

    public STA(String cpf, String nome, int nivel) {
        super(cpf, nome);
        this.nivel = nivel;
    }

    @Override
    public boolean solicitarDiaria() {
        if (totalDiarias < 1) {
            totalDiarias++;
            return true;
        }

        return false;
    }

    @Override
    public double calcularSalarioBase() {
        return 1000 + (100 * nivel);
    }

    @Override
    protected void setTipo() {
        tipo = Tipo.STA;
    }

    @Override
    public boolean verificarValidade() {
        return nivel >= 1 && nivel <= 30;
    }
}