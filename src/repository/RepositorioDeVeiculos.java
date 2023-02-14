package repository;

import entities.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeVeiculos extends RepositorioGenerico<Veiculo> {

    private List<Veiculo> list;

    private List<Veiculo> listaAlugados;

    public RepositorioDeVeiculos()
    {
        this.listaAlugados = new ArrayList<>();
        this.list = new ArrayList<>();
    }

    public List<Veiculo> buscarPorFabricante(String fabricante){
        List<Veiculo> busca = new ArrayList<>();
        for (int i = 0; i < listarTodos().size(); i++) {
            if (listarTodos().get(i).getFabricante().contains(fabricante)){
                busca.add(listarTodos().get(i));
            }
        }
        return busca;
    }

    public List<Veiculo> buscarPorModelo(String modelo){
        List<Veiculo> busca = new ArrayList<>();
        for (int i = 0; i < listarTodos().size(); i++) {
            if (listarTodos().get(i).getModelo().contains(modelo)){
                busca.add(listarTodos().get(i));
            }
        }
        return busca;
    }

    @Override
    public void salvar(Veiculo entidade) {
        if (consultar(entidade.getId()) != null){
            throw new IllegalArgumentException("ID já cadastrado!");
        }
        list.add(entidade);
    }

    @Override
    public void atualizar(Veiculo entidade) {
        if (consultar(entidade.getId()) == null){
            throw new IllegalArgumentException("Impossível atualizar, ID não cadastrado!");
        }
        deletar(entidade.getId());
        salvar(entidade);
    }

    @Override
    public void deletar(String id) {
        if (consultar(id) == null){
            throw new IllegalArgumentException("Impossível deletar, ID não cadastrado!");
        }
        list.remove(consultar(id));
    }

    public void deletarVeiculoAlugado(String id) {
        if (consultarVeiculoAlugado(id) == null){
            throw new IllegalArgumentException("Impossível deletar, ID não cadastrado!");
        }
        list.remove(consultar(id));
    }

    @Override
    public Veiculo consultar(String id) {
        for (Veiculo entidade : list) {
            if (entidade.getId().equals(id)) {
                return entidade;
            }
        }
        return null;
    }

    public Veiculo consultarVeiculoAlugado (String id) {
        for (Veiculo entidade : listaAlugados) {
            if (entidade.getId().equals(id)) {
                return entidade;
            }
        }
        return null;
    }

    @Override
    public List<Veiculo> listarTodos() {
        return new ArrayList<>(list);
    }

    public List<Veiculo> listarTodosAlugados() {
        return new ArrayList<>(listaAlugados);
    }

    public void salvarVeiculoAlugado(Veiculo entidade) {
        if (consultar(entidade.getId()) != null){
            throw new IllegalArgumentException("ID já cadastrado!");
        }
        listaAlugados.add(entidade);
    }
}