package br.ufc.quixada.gestao;

import br.ufc.quixada.gestao.model.Funcionario;
import br.ufc.quixada.gestao.contrato.IRHService;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RHService implements IRHService {
    private Set<Funcionario> funcionarios = new TreeSet<>();

    private boolean cpfJaCadastrado(String cpf) {
        return funcionarios.stream().anyMatch(funcionario -> funcionario.getCpf().equals(cpf));
    }

    @Override
    public boolean cadastrar(Funcionario funcionario) {
        if (!cpfJaCadastrado(funcionario.getCpf()) && funcionario.verificarValidade()) {
            return funcionarios.add(funcionario);
        }

        return false;
    }

    @Override
    public boolean remover(String cpf) {
        return funcionarios.removeIf(funcionario -> funcionario.getCpf().equals(cpf));
    }

    @Override
    public Funcionario obterFuncionario(String cpf) {
        return funcionarios.stream().filter(funcionario -> funcionario.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    @Override
    public List<Funcionario> getFuncionarios() {
        return funcionarios.stream().toList();
    }

    @Override
    public List<Funcionario> getFuncionariosPorCategoria(Tipo tipo) {
        return funcionarios.stream().filter(funcionario -> funcionario.getTipo().equals(tipo)).toList();
    }

    @Override
    public int getTotalFuncionarios() {
        return funcionarios.size();
    }

    @Override
    public boolean solicitarDiaria(String cpf) {
        return funcionarios.stream().filter(funcionario -> funcionario.getCpf().equals(cpf)).findFirst()
                .map(Funcionario::solicitarDiaria).orElse(false);
    }

    @Override
    public void partilharLucros(double valor) {
        if (!funcionarios.isEmpty()) {
            double valorLucro = valor / funcionarios.size();
            funcionarios.forEach(funcionario -> funcionario.setLucro(valorLucro));
        }
    }

    @Override
    public void iniciarMes() {
        funcionarios.forEach(Funcionario::novoMes);
    }

    @Override
    public Double calcularSalarioDoFuncionario(String cpf) {
        return funcionarios.stream().filter(funcionario -> funcionario.getCpf().equals(cpf)).findFirst()
                .map(Funcionario::calcularSalario)
                .orElse(null);
    }

    @Override
    public double calcularFolhaDePagamento() {
        return funcionarios.stream().mapToDouble(Funcionario::calcularSalario).sum();
    }
}