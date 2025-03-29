package br.ufc.quixada.poo;

public class Veiculo {
  private String idenficador;
  protected double valorMinimo;

  public Veiculo(String idenficador) {
    this.idenficador = idenficador;
  }

  public String getIdentificador() {
    return idenficador;
  }
}
