public class Fone {
    private Tipo tipo;
    private String numero;

    public Fone(Tipo tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public static boolean eValido(String numero) {
        return numero.matches("[()0-9-]+");
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getNumero() {
        return numero;
    }
}
