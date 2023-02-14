package repository;

import java.util.List;

public interface Repositorio <T> {

    void salvar(T entidade);

    void atualizar (T entidade);

    void deletar (String id);

    T consultar(String id);

    List<T> listarTodos();


}