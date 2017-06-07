package data.classes.vehicle;

public class Veiculo {

    private String placa;
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

    public void setSituacao(String situacao) throws Exception {
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
                default: throw new Exception("Situação de veiculo inválida.");
        }
                
    }
    
    public Float calcularValor() {
        
    }

}
