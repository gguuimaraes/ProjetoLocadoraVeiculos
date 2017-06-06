package data.classes.client;

public class Endereco {

    private String logradouro = "";
    private int numero = 0;
    private int cep = 0;
    private String cidade = "";
    private String estado = "";
    private String pais = "";
    private String bairro = "";
    private String complemento = "";
    private Tipo tipo = Tipo.RESIDENCIAL;

    public enum Tipo {
        RESIDENCIAL, TRABALHO;

        @Override
        public String toString() {
            switch (this) {
                case RESIDENCIAL:
                    return "RESIDENCIAL";
                case TRABALHO:
                    return "TRABALHO";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public Endereco() {
    }

    public Endereco(String linha) throws Exception {
        String dados[] = linha.split(";");
        if (dados.length != 9) {
            throw new Exception("Dados do endereço incorretos.");
        }
        logradouro = dados[0];
        numero = Integer.parseInt(dados[1]);
        cep = Integer.parseInt(dados[2]);
        cidade = dados[3];
        estado = dados[4];
        pais = dados[5];
        bairro = dados[6];
        complemento = dados[7];
        setTipo(dados[8]);
    }

    public Endereco(String logradouro, int numero, int CEP, String cidade, String estado, String pais, String bairro, String complemento, String tipo) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = CEP;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.bairro = bairro;
        this.complemento = complemento;
        setTipo(tipo);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getCEP() {
        return cep;
    }

    public void setCEP(int CEP) {
        this.cep = CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        switch (tipo) {
            case "RESIDENCIAL":
                this.tipo = Tipo.RESIDENCIAL;
                break;
            case "TRABALHO":
                this.tipo = Tipo.TRABALHO;
                break;
        }
    }

    @Override
    public String toString() {
        return logradouro + ";"
                + numero + ";"
                + cep + ";"
                + cidade + ";"
                + estado + ";"
                + pais + ";"
                + bairro + ";"
                + complemento + ";"
                + tipo.toString() + "\n";
    }

    public String getEndereco() {
        return logradouro + "-"
                + numero + "-"
                + cep + "-"
                + cidade + "-"
                + estado + "-"
                + pais + "-"
                + bairro + "-"
                + complemento + "-"
                + tipo.toString().substring(0, 1);
    }
}
