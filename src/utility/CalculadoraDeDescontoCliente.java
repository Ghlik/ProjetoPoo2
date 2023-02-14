package utility;

import entities.Cliente;

public class CalculadoraDeDescontoCliente {

    public double calcularDesconto(long quantidadeDeDiarias, Cliente cliente) {
        if (cliente.getDocumento().length() == 11) {
            if (quantidadeDeDiarias <= 5L){
                return 0.0;
            }
            return 0.05;
        } else if (cliente.getDocumento().length() == 14) {
            if (quantidadeDeDiarias <= 3L){
                return 0.0;
            }
            return 0.1;
        }

        return 0.0;
    }

}