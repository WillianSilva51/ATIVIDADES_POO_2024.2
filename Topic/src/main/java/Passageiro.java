public class Passageiro {
    private String nome;
    private int idade;

    public Passageiro(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public boolean ePrioritario() {
        return idade >= 65;
    }

    String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return nome + ":" + idade;
    }
}