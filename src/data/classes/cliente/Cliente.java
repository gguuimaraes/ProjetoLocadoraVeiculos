package data.classes.cliente;

public class Cliente {

    private String nomeCompleto;
    private long cnh;
    private CPF cpf;
    private Endereco endereco;
    private Telefone telefone;

    public Cliente() {
    }

    public Cliente(String linha) throws Exception {
        String dados[] = linha.split("|");
        if (dados.length != 5) throw new IllegalArgumentException("Dados do cliente incorretos.");
        nomeCompleto = dados[0];
        cnh = Long.parseLong(dados[1]);
        cpf = new CPF(dados[2]);
        endereco = new Endereco(dados[3]);
        telefone = new Telefone(dados[4]);
    }

    public Cliente(String nomeCompleto, long cnh, CPF cpf, Endereco endereco, Telefone telefone) {
        this.nomeCompleto = nomeCompleto;
        this.cnh = cnh;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public long getCnh() {
        return cnh;
    }

    public void setCnh(long cnh) {
        this.cnh = cnh;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public String toString() {
        return nomeCompleto + "|"
                + cnh + "|"
                + cpf.toString() + "|"
                + endereco.toString() + "|"
                + telefone.toString() + "\n";
    }

}
