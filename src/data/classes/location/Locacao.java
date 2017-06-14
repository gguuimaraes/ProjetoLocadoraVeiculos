package data.classes.location;

import data.classes.client.Cliente;
import data.classes.vehicle.Veiculo;
import data.persistence.ClienteDAO;
import data.persistence.VeiculoDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Locacao {

    private Date dataAbertura;
    private Date dataPrevisaoFechamento;
    private Cliente cliente;
    private Veiculo veiculo;
    private Finalidade finalidade;
    private Area area;
    private Situacao situacao;
    private Date dataFechamento;

    public enum Finalidade {
        TRABALHO, PASSEIO;

        @Override
        public String toString() {
            switch (this) {
                case TRABALHO:
                    return "TRABALHO";
                default:
                    return "PASSEIO";
            }
        }
    }

    public enum Area {
        RURAL, URBANA;

        @Override
        public String toString() {
            switch (this) {
                case RURAL:
                    return "RURAL";
                default:
                    return "URBANA";
            }
        }
    }

    public enum Situacao {
        ABERTA, FECHADA;

        @Override
        public String toString() {
            switch (this) {
                case ABERTA:
                    return "ABERTA";
                default:
                    return "FECHADA";
            }
        }
    }

    public Locacao() {
        dataAbertura = new GregorianCalendar().getTime();
        situacao = Situacao.ABERTA;
        area = Area.RURAL;
        finalidade = Finalidade.TRABALHO;
    }
    
    public Locacao(String linha) throws Exception {
        String dados[] = linha.split(";");
        if (dados.length < 7 || dados.length > 8) throw new Exception("Dados da locação incorretos.");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.dataAbertura = df.parse(dados[0]);
        this.dataPrevisaoFechamento = df.parse(dados[1]);
        this.cliente = new ClienteDAO().getByCNH(dados[2]);
        this.veiculo = new VeiculoDAO().getByPlaca(dados[3]);
        setFinalidade(dados[4]);
        setArea(dados[5]);
        setSituacao(dados[6]);
        if (dados.length == 8 && situacao == Situacao.FECHADA) this.dataFechamento = df.parse(dados[7]);
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

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
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

    private void setSituacao(String situacao) {
        switch (situacao) {
            case "ABERTA":
                this.situacao = Situacao.ABERTA;
                break;
            default:
                this.situacao = Situacao.FECHADA;
        }
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
    
    public void abrir() {
        this.dataAbertura = new GregorianCalendar().getTime();
        veiculo.setSituacao("LOCADO");
    }
    
    public void fechar() {
        this.dataFechamento = new GregorianCalendar().getTime();
        this.situacao = Situacao.FECHADA;
    }

    public long getPrevisaoDias() {
        long diferenca = dataPrevisaoFechamento.getTime() - dataAbertura.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    public long getDiferencaDias() {
        
        long diferenca = dataFechamento.getTime() > dataPrevisaoFechamento.getTime() ? dataFechamento.getTime() - dataPrevisaoFechamento.getTime() : dataPrevisaoFechamento.getTime() - dataFechamento.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }

    private float getValor() {
        float valor = finalidade == Finalidade.TRABALHO ? veiculo.getDiaria() * (float) 0.03 : 0;
        valor += area == Area.RURAL ? veiculo.getDiaria() * (float) 0.03 : 0;
        valor += veiculo.getDiaria();
        return valor;
    }

    public Float getValorPrevisao() {
        return getValor() * getPrevisaoDias() * 2;
    }

    public Float getValorExtornar() {
        if (dataFechamento.getTime() > dataPrevisaoFechamento.getTime()) return (float) 0;
        else if (getDiferencaDias() == 0) return getValorPrevisao() / 2;
        return getValor() * getDiferencaDias() * 2;
    }
    
    public Float getValorPagar() {
        if (dataPrevisaoFechamento.getTime() > dataFechamento.getTime()) return (float) 0;
        float valor = getValorPrevisao() - (getValor() * getDiferencaDias());
        return valor < 0 ? valor * -1 : valor;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(dataAbertura) + ";"
                + dateFormat.format(dataPrevisaoFechamento) + ";"
                + cliente.getCNH() + ";"
                + veiculo.getPlaca() + ";"
                + finalidade.toString() + ";"
                + area.toString() + ";"
                + situacao.toString()
                + (situacao == Situacao.FECHADA ? ";" + dateFormat.format(dataFechamento) : "")
                + "\n";

    }
}
