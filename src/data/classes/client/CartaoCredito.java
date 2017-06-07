package data.classes.client;

public class CartaoCredito {

    private Bandeira bandeira;
    private long numero;
    private int cvc;
    private int mes;
    private int ano;

    public enum Bandeira {
        MASTERCARD, VISA;

        @Override
        public String toString() {
            switch (this) {
                case MASTERCARD:
                    return "MASTERCARD";
                default:
                    return "VISA";
            }
        }
    }

    public CartaoCredito() {
    }

    public CartaoCredito(String linha) throws Exception {
        String dados[] = linha.split(";");
        if (dados.length != 5) throw new Exception("Dados do cartão de crédito incorretos.");
        setBandeira(dados[0]);
        numero = Long.parseLong(dados[1]);
        cvc = Integer.parseInt(dados[2]);
        mes = Integer.parseInt(dados[3]);
        ano = Integer.parseInt(dados[4]);
    }

    public CartaoCredito(String bandeira, long numero, int cvv, int mes, int ano) {
        setBandeira(bandeira);
        this.numero = numero;
        this.cvc = cvv;
        this.mes = mes;
        this.ano = ano;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        switch (bandeira) {
            case "MASTERCARD":
                this.bandeira = Bandeira.MASTERCARD;
                break;
            case "VISA":
                this.bandeira = Bandeira.VISA;
                break;
        }
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public int getCVC() {
        return cvc;
    }

    public void setCVC(int cvc) {
        this.cvc = cvc;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString() {
        return bandeira.toString() + ";"
                + numero + ";"
                + cvc + ";"
                + mes + ";"
                + ano;
    }
}