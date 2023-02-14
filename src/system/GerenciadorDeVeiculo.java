package system;

import entities.Veiculo;
import repository.RepositorioDeVeiculos;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeVeiculo {

    private final RepositorioDeVeiculos repositorioDeVeiculos;

    public GerenciadorDeVeiculo(RepositorioDeVeiculos repositorioDeVeiculos) {
        this.repositorioDeVeiculos = repositorioDeVeiculos;
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        if (isVeiculoDisponivel(veiculo)){
            throw new IllegalArgumentException("Placa já cadastrada");
        }
        if (isVeiculoAlugado(veiculo)){
            throw new IllegalArgumentException("Veículo já cadastrado e encontra-se alugado!");
        }
        repositorioDeVeiculos.salvar(veiculo);
    }

    public void moverVeiculoParaAlugados(Veiculo veiculo) {
        if (!isVeiculoDisponivel(veiculo)){
            throw new IllegalArgumentException("Placa não cadastrada, ou veículo indisponível para aluguel");
        }
        if (isVeiculoAlugado(veiculo)){
            throw new IllegalArgumentException("Veículo já está alugado");
        }

        repositorioDeVeiculos.deletar(veiculo.getId());
        repositorioDeVeiculos.salvarVeiculoAlugado(veiculo);
    }
    public void moverVeiculoParaDisponiveis(Veiculo veiculo) {
        if (!isVeiculoAlugado(veiculo)){
            throw new IllegalArgumentException("Veículo não existe ou não pode ser devolvido por estar alugado");
        }
        if (isVeiculoDisponivel(veiculo)){
            throw new IllegalArgumentException("Veículo não está alugado para devolução");
        }

        repositorioDeVeiculos.deletarVeiculoAlugado(veiculo.getId());
        repositorioDeVeiculos.salvar(veiculo);
    }
    public void removerVeiculo (Veiculo veiculo){
        if (!isVeiculoDisponivel(veiculo)){
            throw new IllegalArgumentException("Veículo não cadastrado ou Veículo alugado");
        }
        if ((isVeiculoAlugado(veiculo))){
            throw new IllegalArgumentException("Impossível remover um veículo que encontra-se alugado");
        }
        repositorioDeVeiculos.deletar(veiculo.getId());
    }
    public void editarVeiculo (Veiculo veiculo){
        if (!isVeiculoDisponivel(veiculo) && !isVeiculoAlugado(veiculo)){
            throw new IllegalArgumentException("Veículo não cadastrado");
        }
        if (isVeiculoDisponivel(veiculo)){
            repositorioDeVeiculos.deletar(veiculo.getId());
            repositorioDeVeiculos.salvar(veiculo);
        }
        if (isVeiculoAlugado(veiculo)){
            repositorioDeVeiculos.deletar(veiculo.getId());
            repositorioDeVeiculos.salvar(veiculo);
        }
    }
    public List<Veiculo> buscarVeiculoPorModelo(String modelo){
        List<Veiculo> veiculosDisponiveis = repositorioDeVeiculos.buscarPorModelo(modelo);
        List<Veiculo> veiculosAlugados = repositorioDeVeiculos.buscarPorModelo(modelo);
        List<Veiculo> todosEncontrados = new ArrayList<>();
        todosEncontrados.addAll(veiculosDisponiveis);
        todosEncontrados.addAll(veiculosAlugados);
        return todosEncontrados;
    }
    public List<Veiculo> buscarVeiculoPorFabricante(String fabricante){
        List<Veiculo> veiculosDisponiveis = repositorioDeVeiculos.buscarPorFabricante(fabricante);
        List<Veiculo> veiculosAlugados = repositorioDeVeiculos.buscarPorFabricante(fabricante);
        List<Veiculo> todosEncontrados = new ArrayList<>();
        todosEncontrados.addAll(veiculosDisponiveis);
        todosEncontrados.addAll(veiculosAlugados);
        return todosEncontrados;
    }

    public List<Veiculo> listarVeiculosDisponiveis(){
        return repositorioDeVeiculos.listarTodos();
    }
    public List<Veiculo> listarVeiculosAlugados(){
        return repositorioDeVeiculos.listarTodosAlugados();
    }

   public boolean isVeiculoDisponivel(Veiculo veiculo) {
        return repositorioDeVeiculos.consultar(veiculo.getId()) != null;
    }

    public boolean isVeiculoAlugado(Veiculo veiculo) {
        return repositorioDeVeiculos.consultarVeiculoAlugado(veiculo.getId()) != null;
    }

}