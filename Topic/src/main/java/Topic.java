import java.util.Collections;
import java.util.ArrayList;

public class Topic {
    private ArrayList<Passageiro> preferenciais;
    private ArrayList<Passageiro> normais;
    private int capacidade;
    private int qtdPrioritatios;

    public Topic(int capacidade, int qtdPrioritatios) {
        this.capacidade = capacidade;
        this.qtdPrioritatios = qtdPrioritatios;
        preferenciais = new ArrayList<>(Collections.nCopies(qtdPrioritatios, null));
        normais = new ArrayList<>(Collections.nCopies(capacidade - qtdPrioritatios, null));
    }

    public int getNumeroAssentosPrioritarios() {
        return qtdPrioritatios;
    }

    public int getNumeroAssentosNormais() {
        return capacidade - qtdPrioritatios;
    }

    public Passageiro getPassageiroAssentoNormal(int lugar) {
        return normais.get(lugar);
    }

    public Passageiro getPassageiroAssentoPrioritario(int lugar) {
        return preferenciais.get(lugar);
    }

    public int getVagas() {
        return (int) normais.stream().filter(p -> p == null).count()
                + (int) preferenciais.stream().filter(p -> p == null).count();
    }

    public boolean subir(Passageiro passageiro) {
        if (isTopicCheia() || isPassageiroPresente(passageiro.getNome())) {
            return false;
        }

        if (!passageiro.ePrioritario()) {
            for (int i = 0; i < normais.size(); i++) {
                if (normais.get(i) == null) {
                    normais.set(i, passageiro);
                    return true;
                }
            }
            for (int i = 0; i < preferenciais.size(); i++) {
                if (preferenciais.get(i) == null) {
                    preferenciais.set(i, passageiro);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < preferenciais.size(); i++) {
                if (preferenciais.get(i) == null) {
                    preferenciais.set(i, passageiro);
                    return true;
                }
            }
            for (int i = 0; i < normais.size(); i++) {
                if (normais.get(i) == null) {
                    normais.set(i, passageiro);
                    return true;
                }
            }
        }
        return false;

    }

    public boolean descer(String nome) {
        return descerPass(nome, normais) || descerPass(nome, preferenciais);
    }

    private final boolean descerPass(String nome, ArrayList<Passageiro> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null && list.get(i).getNome().equals(nome)) {
                list.set(i, null);
                return true;
            }
        }

        return false;
    }

    boolean isTopicCheia() {
        return getVagas() == 0;
    }

    boolean isPassageiroPresente(String id) {
        return normais.stream().anyMatch(p -> p != null && p.getNome().equals(id))
                || preferenciais.stream().anyMatch(p -> p != null && p.getNome().equals(id));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        // Prioritários
        for (Passageiro passageiro : preferenciais) {
            sb.append("@").append(passageiro != null ? passageiro : "").append(" ");
        }

        // Assentos Normais
        for (Passageiro passageiro : normais) {
            sb.append("=").append(passageiro != null ? passageiro : "").append(" ");
        }
        sb.append("]");

        return sb.toString();
    }
}