package entities;

import java.time.LocalDateTime;

public class Aluguel implements Entidade{

     private final Cliente cliente;
     private final LocalDateTime dataEhoraDeInicio;
     private final Veiculo veiculo;

     public Aluguel(Cliente cliente, LocalDateTime daraEhoraDeInicio, Veiculo veiculo) {
          this.cliente = cliente;
          this.dataEhoraDeInicio = daraEhoraDeInicio;
          this.veiculo = veiculo;
     }

     public Cliente getCliente() {
          return cliente;
     }

     public LocalDateTime getDataEhoraDeInicio() {
          return dataEhoraDeInicio;
     }

     public Veiculo getVeiculo() {
          return veiculo;
     }

     @Override
     public String getId() {
          return veiculo.getId();
     }

     @Override
     public String toString() {
          return this.veiculo + " alugado para o(a) Sr(a) " + this.cliente + " (" + dataEhoraDeInicio + " )";
     }
}