package entities;

public class Veiculo implements Entidade {

    private String fabricante;
    private String modelo;
    private String placa;
    private int tipoVeiculo;
    private boolean estaAlugado;

    public Veiculo(){

    }

    public Veiculo(String fabricante, String modelo, String placa, int tipoVeiculo) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTipoVeiculo(int tipoVeiculo) {this.tipoVeiculo = tipoVeiculo;}

    public int getTipoVeiculo() { return tipoVeiculo; }

    public void setEstaAlugado(boolean estaAlugado) {this.estaAlugado = estaAlugado;}

    public boolean getEstaAlugado() { return estaAlugado; }

    @Override
    public String getId() {
        return this.placa;
    }

    @Override
    public String toString() {
        return  fabricante + " " + modelo + " (placa: " + placa + ")";
    }
}