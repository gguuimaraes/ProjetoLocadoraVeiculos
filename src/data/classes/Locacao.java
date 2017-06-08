package data.classes;

import data.classes.client.Cliente;
import data.classes.vehicle.Veiculo;
import java.util.Calendar;
import java.util.Date;

public class Locacao {
    private Date dataAbertura;
    private Date dataFechamento;
    private Cliente cliente;
    private Veiculo veiculo;
    private Finalidade finalidade;
    private Area area;
    private Situacao situacao = Situacao.ABERTA;
    
    public enum Finalidade {
        TRABALHO, PASSEIO;
    }
    
    public enum Area {
        RURAL, URBANA;
    }
    
    private enum Situacao { 
        ABERTA, FECHADA;
    } 
    
    public Locacao() {
        this.dataAbertura = Calendar.getInstance().getTime();
    }
}
