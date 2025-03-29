package br.ufc.quixada.gestao.model;

import br.ufc.quixada.gestao.contrato.IRHService.Tipo;

public class Professor extends Funcionario {
    private char classe;

    public Professor(String cpf, String nome, char classe) {
        super(cpf, nome);
        this.classe = classe;
    }

    @Override
    public boolean solicitarDiaria() {
        if (totalDiarias < 3) {
            totalDiarias++;
            return true;
        }

        return false;
    }

    @Override
    public double calcularSalarioBase() {
        return switch (classe) {
            case 'A' -> 3000;
            case 'B' -> 5000;
            case 'C' -> 7000;
            case 'D' -> 9000;
            case 'E' -> 11000;
            default -> 0;
        };
    }

    @Override
    protected void setTipo() {
        tipo = Tipo.PROF;
    }

    @Override
    public boolean verificarValidade() {
        return classe >= 'A' && classe <= 'E';
    }
}