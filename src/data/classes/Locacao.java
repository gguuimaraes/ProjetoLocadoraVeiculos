package data.classes;

import data.classes.client.Cliente;
import data.classes.vehicle.Veiculo;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Locacao {
    private final Date dataAbertura;
    private Date dataPrevisaoFechamento;
    private Date dataFechamento;
    private Cliente cliente;
    private Veiculo veiculo;
    private Finalidade finalidade;
    private Area area;
    private Situacao situacao;
    
    public enum Finalidade {
        TRABALHO, PASSEIO;
        
        @Override
        public String toString() {
            switch (this) {
                case TRABALHO: return "TRABALHO";
                default: return "PASSEIO";
            }
        }
    }
    
    public enum Area {
        RURAL, URBANA;
        
        @Override
        public String toString() {
            switch (this) {
                case RURAL: return "RURAL";
                default: return "URBANA";
            }
        }
    }
    
    private enum Situacao { 
        ABERTA, FECHADA;
        
        @Override
        public String toString() {
            switch (this) {
                case ABERTA: return "ABERTA";
                default: return "FECHADA";
            }
        }
    } 
    
    public Locacao(Date dataAbertura, Date dataPrevisaoFechamento, Cliente cliente, Veiculo veiculo, String finalidade, String area) {
        this.dataAbertura = dataAbertura;
        this.dataPrevisaoFechamento = dataPrevisaoFechamento;
        this.cliente = cliente;
        this.veiculo = veiculo;
        setFinalidade(finalidade);
        setArea(area);
        this.situacao = Situacao.ABERTA;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public Date getDataPrevisaoFechamento() {
        return dataPrevisaoFechamento;
    }

    public void setDataPrevisaoFechamento(Date dataPrevisaoFechamento) {
        this.dataPrevisaoFechamento = dataPrevisaoFechamento;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Finalidade getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        switch (finalidade) {
            case "TRABALHO": 
                this.finalidade = Finalidade.TRABALHO;
                break;
            default: 
                this.finalidade = Finalidade.PASSEIO;
        }
    }

    public Area getArea() {
        return area;
    }

    public void setArea(String area) {
        switch (area) {
            case "RURAL": 
                this.area = Area.RURAL;
                break;
            default: 
                this.area = Area.URBANA;
        }
    }

    public Situacao getSituacao() {
        return situacao;
    }
    
    public void fechar() {
        this.dataFechamento = new GregorianCalendar().getTime();
        this.situacao = Situacao.FECHADA;
    }
    
    public int getPrevisaoDias() {
        long diferenca = dataPrevisaoFechamento.getTime() - dataAbertura.getTime();
        return (int) TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }
    
    public int getTotalDias() {
        long diferenca = dataFechamento.getTime() - dataAbertura.getTime();
        return (int) TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }
    
    private float getValor() {
        float valor = finalidade == Finalidade.TRABALHO ? veiculo.getDiaria() * (float) 0.03 : 0;
        valor += area == Area.RURAL ? veiculo.getDiaria() * (float) 0.03 : 0;
        valor += veiculo.getDiaria();
        return valor;
    }
    
    public float getValorPrevisao() {
        return getValor() * getPrevisaoDias() * 2;
    }
    
    public float getValorTotal() {
        return getValor() * getTotalDias() * 2;
    }
}
