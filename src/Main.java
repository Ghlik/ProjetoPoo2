import entities.*;
import repository.RepositorioDeClientes;
import repository.RepositorioDeVeiculos;
import system.GerenciadorDeAluguel;
import system.GerenciadorDeCliente;
import system.GerenciadorDeVeiculo;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {

        RepositorioDeClientes repositorioDeClientes = new RepositorioDeClientes();
        RepositorioDeVeiculos repositorioDeVeiculos = new RepositorioDeVeiculos();

        GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo(repositorioDeVeiculos);
        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente(repositorioDeClientes);
        GerenciadorDeAluguel gerenciadorDeAluguel = new GerenciadorDeAluguel(gerenciadorDeCliente, gerenciadorDeVeiculo);

        Cliente cliente1 = new Cliente("cliente1", "11111111111");
        Cliente cliente2 = new Cliente("cliente2", "22222222222");
        Cliente cliente3 = new Cliente("cliente3", "33333333333");
        Cliente clientePJ1 = new Cliente("clientePJ1", "44444444444444444");
        Cliente clientePJ2 = new Cliente("clientePJ2", "55555555555555555");

        Veiculo veiculoPequeno1 = new Veiculo("Hyundai", "HB20", "PPP1P11", 1);
        Veiculo veiculoPequeno2 = new Veiculo("Hyundai", "HB20", "PPP2P22", 1);
        Veiculo veiculoPequeno3 = new Veiculo("Fiat", "Uno", "PPP3P33", 1);
        Veiculo veiculoMedio1 = new Veiculo("Nissan", "Versa", "MMM1M11", 2);
        Veiculo veiculoMedio2 = new Veiculo("Fiat", "Cronos", "MMM2M22", 2);
        Veiculo veiculoMedio3 = new Veiculo("Honda", "Wr-v", "MMM3M33", 2);
        Veiculo veiculoSUV1 = new Veiculo("Hyundai", "Creta", "SUV1S11", 3);
        Veiculo veiculoSUV2 = new Veiculo("Fiat", "Pulse", "SUV2S22", 3);
        Veiculo veiculoSUV3 = new Veiculo("Nissan", "Kicks", "SUV3S33", 3);

        gerenciadorDeCliente.cadastrarCliente(cliente1);
        gerenciadorDeCliente.cadastrarCliente(cliente2);
        gerenciadorDeCliente.cadastrarCliente(cliente3);
        gerenciadorDeCliente.cadastrarCliente(clientePJ1);
        gerenciadorDeCliente.cadastrarCliente(clientePJ2);

        System.out.println("Clientes com cadastro: ");
        System.out.println(gerenciadorDeCliente.listarClientes());
        System.out.println();

        //Alterando clientes
        Cliente cliente2Alterado = new Cliente("Cliente2Alterado", "22222222222");
        gerenciadorDeCliente.editarCliente(cliente2Alterado);
        System.out.println("Clientes com cadastrado após edição: ");
        System.out.println(gerenciadorDeCliente.listarClientes());
        System.out.println();

        //Cadastrando Veiculos
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoPequeno1);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoPequeno2);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoPequeno3);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoMedio1);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoMedio2);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoMedio3);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoSUV1);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoSUV2);
        gerenciadorDeVeiculo.cadastrarVeiculo(veiculoSUV3);

        System.out.println("Veículos Disponíveis: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosDisponiveis());
        System.out.println("Veículos Alugados: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosAlugados());
        System.out.println();

        //Alterando veículos
        Veiculo veiculoSUV3Alterado = new Veiculo("Nissan", "Kicks 2023", "SUV3S33", 3);

        gerenciadorDeVeiculo.editarVeiculo(veiculoSUV3Alterado);

        System.out.println("Veículos Disponíveis após edição: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosDisponiveis());
        System.out.println("Veículos Alugados: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosAlugados());
        System.out.println();

        //Buscando veículos por parte do nome do modelo ou fabricante
        System.out.println("Buscando por modelo que contenha s");
        System.out.println(gerenciadorDeVeiculo.buscarVeiculoPorModelo("s"));
        System.out.println("Buscando por fabricante que contenha yund");
        System.out.println(gerenciadorDeVeiculo.buscarVeiculoPorFabricante("yund"));
        System.out.println();

        //Alugando veículos
        Aluguel aluguel1 = gerenciadorDeAluguel.alugarVeiculoPF(cliente1, LocalDateTime.of(2023, Month.FEBRUARY, 13, 11, 49), veiculoMedio1);
        Aluguel aluguel2 =gerenciadorDeAluguel.alugarVeiculoPF(clientePJ1, LocalDateTime.of(2023, Month.FEBRUARY, 13, 11, 49), veiculoSUV1);
        Aluguel aluguel3 =gerenciadorDeAluguel.alugarVeiculoPF(cliente3, LocalDateTime.of(2023, Month.FEBRUARY, 13, 11, 49), veiculoPequeno2);
        Aluguel aluguel4 =gerenciadorDeAluguel.alugarVeiculoPF(clientePJ2, LocalDateTime.of(2023, Month.FEBRUARY, 13, 11, 49), veiculoPequeno3);

        System.out.println("Veículos Disponíveis: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosDisponiveis());
        System.out.println("Veículos Alugados: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosAlugados());
        System.out.println();

        //Devolvendo veículos
        gerenciadorDeAluguel.devolverVeiculo(aluguel1, LocalDateTime.of(2023, Month.APRIL, 13, 11, 54));
        gerenciadorDeAluguel.devolverVeiculo(aluguel2, LocalDateTime.of(2023, Month.FEBRUARY, 16, 11, 54));
        gerenciadorDeAluguel.devolverVeiculo(aluguel3, LocalDateTime.of(2023, Month.FEBRUARY, 14, 11, 54));

        System.out.println();
        System.out.println("Veículos Disponíveis: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosDisponiveis());
        System.out.println("Veículos Alugados: ");
        System.out.println(gerenciadorDeVeiculo.listarVeiculosAlugados());
        System.out.println();

    }
}