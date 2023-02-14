package system;

import entities.*;
import utility.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GerenciadorDeAluguel {

    private GerenciadorDeCliente gerenciadorDeClientesPF;
    private GerenciadorDeVeiculo gerenciadorDeVeiculo;
    private final CalculadoraDeDescontoCliente calculadoraDeDescontoCliente = new CalculadoraDeDescontoCliente();
    private final CalculaDiarias calculaDiariasVeiculo = new CalculaDiarias();
    private final CalculadoraDeQuantidadeDeDiarias calcularQuantidadeDeDiarias = new CalculadoraDeQuantidadeDeDiarias();

    public GerenciadorDeAluguel(GerenciadorDeCliente gerenciadorDeClientesPF, GerenciadorDeVeiculo gerenciadorDeVeiculo) {
        this.gerenciadorDeClientesPF = gerenciadorDeClientesPF;
        this.gerenciadorDeVeiculo = gerenciadorDeVeiculo;
    }

    public Aluguel alugarVeiculoPF (Cliente cliente, LocalDateTime dataEHoraDeAluguel, Veiculo veiculo){
        Aluguel aluguel = new Aluguel(cliente, dataEHoraDeAluguel, veiculo);
        gerenciadorDeVeiculo.moverVeiculoParaAlugados(veiculo);
        return aluguel;
    }

    public void devolverVeiculo (Aluguel aluguel, LocalDateTime dataDaDevolucao){
        gerenciadorDeVeiculo.moverVeiculoParaDisponiveis(aluguel.getVeiculo());
        BigDecimal valorDoAluguel = calcularValorDoAluguel(aluguel, dataDaDevolucao);
        Long quantidadeDeDiarias = calcularQuantidadeDeDiarias(aluguel, dataDaDevolucao);
        System.out.println("Quantidade de Diárias: " + quantidadeDeDiarias);
        System.out.println("Valor do aluguel: $" + valorDoAluguel);
    }

    private BigDecimal calcularValorTotal(Aluguel aluguel, LocalDateTime dataDaDevolucao){
        long quantidadeDeDiarias = calcularQuantidadeDeDiarias(aluguel, dataDaDevolucao);
        return calculaDiariasVeiculo.calcularValorTotal(quantidadeDeDiarias, aluguel.getVeiculo());
    }
    private double calcularDesconto (Aluguel aluguel, LocalDateTime dataDaDevolucao) {
        long quantidadeDeDiarias = calcularQuantidadeDeDiarias(aluguel, dataDaDevolucao);
        return calculadoraDeDescontoCliente.calcularDesconto(quantidadeDeDiarias, aluguel.getCliente());
    }
    public BigDecimal calcularValorDoAluguel (Aluguel aluguel, LocalDateTime dataDaDevolucao){
        BigDecimal valorTotal =  calcularValorTotal(aluguel, dataDaDevolucao);
        Double desconto = calcularDesconto(aluguel, dataDaDevolucao);
        return valorTotal.multiply(BigDecimal.valueOf(1L-desconto));
    }
    public long calcularQuantidadeDeDiarias (Aluguel aluguel, LocalDateTime dataDaDevolucao){
        return calcularQuantidadeDeDiarias.calcularQuantidadeDeDiarias(aluguel.getDataEhoraDeInicio(), dataDaDevolucao);
    }

}