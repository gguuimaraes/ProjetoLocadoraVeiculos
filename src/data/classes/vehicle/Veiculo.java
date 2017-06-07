package data.classes.vehicle;

import data.persistence.MarcaDAO;

public class Veiculo {

    private String placa;
    private Marca marca;
    private Modelo modelo;
    private int ano;
    private Situacao situacao;

    private enum Situacao {
        DISPONIVEL, LOCADO, SINISTRADO, VENDIDO, INATIVO;

        @Override
        public String toString() {
            switch (this) {
                case DISPONIVEL:
                    return "DISPONIVEL";
                case LOCADO:
                    return "LOCADO";
                case SINISTRADO:
                    return "SINISTRADO";
                case VENDIDO:
                    return "VENDIDO";
                default:
                    return "INATIVO";
            }
        }
    }

    public Veiculo() {
    }

    public Veiculo(String placa, Marca marca, Modelo modelo, int ano, String situacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        setSituacao(situacao);
    }
    
    public Veiculo(String linha) throws Exception {
        String dados[] = linha.split(";");
        if (dados.length != 5) throw new Exception("Dados do veículo incorretos.");
        placa = dados[0];
        marca = new MarcaDAO().getByNome(dados[1]);
        modelo = new MarcaDAO().getModeloByNome(dados[2]);
        ano = Integer.parseInt(dados[3]);
        setSituacao(dados[4]);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getSituacao() {
        return situacao.toString();
    }

    public void setSituacao(String situacao) {
        switch (situacao) {
            case "DISPONIVEL":
                this.situacao = Situacao.DISPONIVEL;
            case "LOCADO":
                this.situacao = Situacao.LOCADO;
            case "SINISTRADO":
                this.situacao = Situacao.SINISTRADO;
            case "VENDIDO":
                this.situacao = Situacao.VENDIDO;
            case "INATIVO":
                this.situacao = Situacao.INATIVO;
        }

    }

    public Float calcularValor() {
        return 
    }

}
