package br.ufc.quixada.poo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
  private List<Ticket> tickets = new ArrayList<>();
  private int vagasCarro;
  private int vagasMotoBike;

  public Estacionamento(int vagasCarro, int vagasMotoBike) {
    this.vagasCarro = vagasCarro;
    this.vagasMotoBike = vagasMotoBike;
  }

  public boolean estacionarCarro(Veiculo veiculo) {
    if (vagasCarro > 0) {
      tickets.add(new Ticket(veiculo));
      vagasCarro--;

      System.out.println("Carro estacionado.");

      return true;
    } else {
      System.out.println("Não há vagas disponíveis para carros.");

      return false;
    }
  }

  public boolean estacionarMotoBike(Veiculo veiculo) {
    if (vagasMotoBike > 0) {
      tickets.add(new Ticket(veiculo));
      vagasMotoBike--;

      System.out.println("Moto estacionada.");

      return true;
    } else {
      System.out.println("Não há vagas disponíveis para motos.");

      return false;
    }
  }

  public boolean registrarEntrada(Veiculo veiculo) {
    if (getTicketBy(veiculo.getIdentificador()) != null) {
      System.out.println("Veículo já está estacionado.");
      return false;
    }

    if (veiculo instanceof Carro)
      return estacionarCarro(veiculo);

    else if (veiculo instanceof Moto || veiculo instanceof Bike)
      return estacionarMotoBike(veiculo);

    System.out.println("Tipo de veículo inválido.");
    return false;
  }

  public void ajustarVagas(Ticket ticket) {
    if (ticket.getVeiculo() instanceof Carro) {
      vagasCarro++;
    } else {
      vagasMotoBike++;
    }
  }

  public boolean registrarSaida(String identificador, LocalDateTime horaDeSaida) {
    Ticket ticket = getTicketBy(identificador);

    if (ticket != null) {
      ticket.registrarSaida(horaDeSaida);

      ajustarVagas(ticket);

      tickets.remove(ticket);

      return true;
    }

    return false;
  }

  public Ticket getTicketBy(String identificador) {
    return tickets.stream().filter(ticket -> ticket.getVeiculo().getIdentificador().equals(identificador)).findFirst()
        .orElse(null);
  }

  public Veiculo[] listarVeiculosEstacionados() {
    return tickets.stream().map(Ticket::getVeiculo).toArray(Veiculo[]::new);
  }

  public int vagasDisponiveisPara(TipoVaga tipo) {
    switch (tipo) {
      case CARRO:
        return vagasCarro;

      case MOTO_E_BIKE:
        return vagasMotoBike;

      default:
        System.out.println("Tipo de vaga inválido.");
        return 0;
    }
  }
}
