package repository;

import entities.Entidade;

import java.util.ArrayList;
import java.util.List;

public class RepositorioGenerico<T extends Entidade> implements Repositorio <T>{

    private List<T> list;

    public RepositorioGenerico() {
        this.list = new ArrayList<>();
    }

    @Override
    public void salvar(T entidade) {
        if (consultar(entidade.getId()) != null){
            throw new IllegalArgumentException("ID já cadastrado!");
        }
        list.add(entidade);
    }

    @Override
    public void atualizar(T entidade) {
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

    @Override
    public T consultar(String id) {
        for (T entidade : list) {
            if (entidade.getId().equals(id)) {
                return entidade;
            }
        }
        return null;
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(list);
    }
}