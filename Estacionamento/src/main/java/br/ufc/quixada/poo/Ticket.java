package br.ufc.quixada.poo;

import java.time.LocalDateTime;
import java.time.Duration;

public class Ticket {
  private Veiculo veiculo;
  private LocalDateTime horaEntrada;
  private double valorPago;
  private boolean pago;

  public Ticket(Veiculo veiculo) {
    this.veiculo = veiculo;
    this.horaEntrada = LocalDateTime.now();
  }

  public double getValorPago() {
    return valorPago;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public boolean isPago() {
    return pago;
  }

  public LocalDateTime getHoraEntrada() {
    return horaEntrada;
  }

  private double calcularValorPorTipo(Duration duration, double valorPorMinuto, double valorMinimo) {
    return Math.max(duration.toMinutes() * valorPorMinuto, valorMinimo);
  }

  private void calcularValor(Duration duracao) {
    if (veiculo instanceof Carro) {
      valorPago = calcularValorPorTipo(duracao, 0.1, 5);

    } else if (veiculo instanceof Moto) {
      valorPago = calcularValorPorTipo(duracao, 0.05, 3);

    } else {
      valorPago = 3;
    }
  }

  public boolean registrarSaida(LocalDateTime horaDeSaida) {
    calcularValor(Duration.between(horaEntrada, horaDeSaida));

    pago = true;

    return true;

  }
}
