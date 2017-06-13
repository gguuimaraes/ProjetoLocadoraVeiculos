package data.classes.vehicle;

import data.persistence.MarcaDAO;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Veiculo {

    private String placa;
    private Marca marca;
    private Modelo modelo;
    private int ano;
    private float quilometragem;
    private Situacao situacao;

    public enum Situacao {
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

    public Veiculo(String placa, Marca marca, Modelo modelo, int ano, float quilometragem, String situacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        setSituacao(situacao);
    }
    
    public Veiculo(String linha) throws Exception {
        String dados[] = linha.split(";");
        if (dados.length != 6) throw new Exception("Dados do veículo incorretos.");
        placa = dados[0];
        MarcaDAO marcaDAO = new MarcaDAO();
        marca = marcaDAO.getByNome(dados[1]);
        modelo = marcaDAO.getModeloByNome(dados[2]);
        ano = Integer.parseInt(dados[3]);
        quilometragem = Float.parseFloat(dados[4]);
        setSituacao(dados[5]);
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

    public Integer getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }
    
    public void setSituacao(String situacao) {
        switch (situacao) {
            case "DISPONIVEL":
                this.situacao = Situacao.DISPONIVEL;
                break;
            case "LOCADO":
                this.situacao = Situacao.LOCADO;
                break;
            case "SINISTRADO":
                this.situacao = Situacao.SINISTRADO;
                break;
            case "VENDIDO":
                this.situacao = Situacao.VENDIDO;
                break;
            case "INATIVO":
                this.situacao = Situacao.INATIVO;
                break;
        }

    }

    public Float getDiaria() {
        int diferencaAno = new GregorianCalendar().get(Calendar.YEAR) - ano;
        float valor = marca.getValor() + modelo.getValor();
        return valor - (valor * diferencaAno * (float) 0.05);
    }

    @Override
    public String toString() {
        return placa + ";" +
                marca.getNome() + ";" +
                modelo.getNome() + ";" + 
                ano + ";" +
                quilometragem + ";" +
                situacao.toString() + "\n";
    }
    
}
