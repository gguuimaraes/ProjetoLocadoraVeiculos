package data.classes.client;

public class Telefone {

    private int ddi = 0;
    private int ddd = 0;
    private int numero = 0;
    private Tipo tipo = Tipo.RESIDENCIAL;

    public enum Tipo {
        PESSOAL, RESIDENCIAL, TRABALHO;

        @Override
        public String toString() {
            switch (this) {
                case PESSOAL:
                    return "PESSOAL";
                case RESIDENCIAL:
                    return "RESIDENCIAL";
                default:
                    return "TRABALHO";
            }
        }
    }

    public Telefone() {
    }

    public Telefone(String linha) throws Exception {
        String dados[] = linha.split(";");
        if (dados.length != 4) {
            throw new Exception("Dados do telefone incorretos.");
        }
        ddi = Integer.parseInt(dados[0]);
        ddd = Integer.parseInt(dados[1]);
        numero = Integer.parseInt(dados[2]);
        setTipo(dados[3]);
    }

    public Telefone(int DDI, int DDD, int numero, String tipo) {
        this.ddi = DDI;
        this.ddd = DDD;
        this.numero = numero;
        setTipo(tipo);
    }

    public Integer getDDI() {
        return ddi;
    }

    public void setDDI(int DDI) {
        this.ddi = DDI;
    }

    public Integer getDDD() {
        return ddd;
    }

    public void setDDD(int DDD) {
        this.ddd = DDD;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        switch (tipo) {
            case "PESSOAL":
                this.tipo = Tipo.PESSOAL;
                break;
            case "RESIDENCIAL":
                this.tipo = Tipo.RESIDENCIAL;
                break;
            case "TRABALHO":
                this.tipo = Tipo.TRABALHO;
                break;
        }
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return ddi + ";"
                + ddd + ";"
                + numero + ";"
                + tipo.toString();
    }

    public String getTelefone() {
        return ddi + "-" + ddd + "-" + numero + "-" + (tipo.toString().substring(0, 1));
    }
}
