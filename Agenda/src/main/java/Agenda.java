import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
    private Map<String, Contato> contatos = new TreeMap<>();

    private boolean contatoExiste(String key) {
        return contatos.containsKey(key);
    }

    public List<Contato> getContatos() {
        return List.copyOf(contatos.values());
    }

    public int getQuantidadeDeContatos() {
        return contatos.size();
    }

    public Contato getContato(String name) {
        return contatos.get(name);
    }


    public boolean adicionarContato(Contato contato) {
        if (contato.getFones().isEmpty()) {
            return false;
        }

        if (contatoExiste(contato.getNome())) {
            contato.getFones().forEach(fone -> contatos.get(contato.getNome()).adicionarFone(fone));
            return false;
        }

            contatos.put(contato.getNome(), contato);
            return true;
    }
    
    public boolean removerContato(String name) {
        if (contatoExiste(name)) {
            contatos.remove(name);
            return true;
        }

        return false;
    }

    public boolean removerFone(String name, int index) {
        if (contatoExiste(name)) {
            return contatos.get(name).removerFone(index);
        }

        return false;
    }

    public int getQuantidadeDeFones(Tipo tipo) {
        return (int) contatos.values().stream()
                .mapToLong(c -> c.getFones().stream().filter(f -> f.getTipo().equals(tipo)).count()).sum();
    }

    public int getQuantidadeDeFones() {
        return contatos.values().stream().mapToInt(c -> c.getFones().size()).sum();
    }

    public List<Contato> pesquisar(String expressao) {
        if (expressao.isEmpty()) {
            return Collections.emptyList();
        }

        if (Fone.eValido(expressao)) {
            return contatos.values().stream()
                    .filter(c -> c.getFones().stream().anyMatch(f -> f.getNumero().contains(expressao))).toList();
        }

        return contatos.values().stream().filter(c -> c.getNome().contains(expressao)).toList();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        contatos.values().forEach(contato -> sb.append(contato).append("\n"));

        return sb.toString();
    }
}