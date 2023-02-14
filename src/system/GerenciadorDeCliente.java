package system;

import entities.Cliente;
import repository.RepositorioDeClientes;

import java.util.List;

public class GerenciadorDeCliente {
    private final RepositorioDeClientes repositorioDeClientes;

    public GerenciadorDeCliente(RepositorioDeClientes repositorioDeClientes) {
        this.repositorioDeClientes = repositorioDeClientes;
    }

    public void cadastrarCliente (Cliente cliente){
        if (isClienteCadastrado(cliente.getId())){
            throw new IllegalArgumentException("Cliente já cadastrado");
        }
        repositorioDeClientes.salvar(cliente);
    }
    public void editarCliente (Cliente cLienteEditado){
        if (!isClienteCadastrado(cLienteEditado.getId())){
            throw new IllegalArgumentException("id não cadastrado!");
        }
        repositorioDeClientes.atualizar(cLienteEditado);
    }

    public void editarClientePJ (String cnpj, String nome){
        if (!isClienteCadastrado(cnpj)){
            throw new IllegalArgumentException("id não cadastrado!");
        }

        Cliente clienteASerEditado = (Cliente) repositorioDeClientes.consultar(cnpj);
        clienteASerEditado.setNome(nome);
        repositorioDeClientes.atualizar(clienteASerEditado);
    }


    public Cliente buscarCliente (String id){
        return (repositorioDeClientes.consultar(id));
    }


    public void excluirClientePF (Cliente cliente){
        if (!isClienteCadastrado(cliente)){
            throw new IllegalArgumentException("Cliente não cadastrado");
        }
        repositorioDeClientes.deletar(cliente.getId());
    }

    public List<Cliente> listarClientes (){
        return repositorioDeClientes.listarTodos();
    }

    private boolean isClienteCadastrado (Cliente cliente){
        return repositorioDeClientes.consultar(cliente.getId()) != null;
    }
    private boolean isClienteCadastrado (String id){
        return repositorioDeClientes.consultar(id) != null;
    }

}