package utility;

import entities.Veiculo;

import java.math.BigDecimal;

public class CalculaDiarias {

    public BigDecimal calcularValorTotal(long quantidadeDeDiarias, Veiculo veiculo) {
        if (veiculo.getTipoVeiculo() == 1) {
            BigDecimal valorDaDiaria = new BigDecimal(100.0);
            BigDecimal valorTotal = valorDaDiaria.multiply(BigDecimal.valueOf(quantidadeDeDiarias));
            return valorTotal;
        } else if (veiculo.getTipoVeiculo() == 2) {
            BigDecimal valorDaDiaria = new BigDecimal(150.0);
            BigDecimal valorTotal = valorDaDiaria.multiply(BigDecimal.valueOf(quantidadeDeDiarias));
            return valorTotal;
        } else if ( veiculo.getTipoVeiculo() == 3) {
            BigDecimal valorDaDiaria = new BigDecimal(200.0);
            BigDecimal valorTotal = valorDaDiaria.multiply(BigDecimal.valueOf(quantidadeDeDiarias));
            return valorTotal;
        }

        return new BigDecimal(0.0);
    }



}