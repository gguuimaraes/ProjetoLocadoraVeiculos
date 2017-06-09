package data.classes.client;

public class Cliente {

    private String nomeCompleto;
    private String cnh;
    private CPF cpf;
    private Email email;
    private Endereco endereco;
    private Telefone telefone;

    public Cliente() {
    }

    public Cliente(String linha) throws Exception {
        String dados[] = linha.split("\\|");
        System.out.println(dados.length);
        if (dados.length != 6) throw new Exception("Dados do cliente incorretos.");
        cnh = dados[0];
        nomeCompleto = dados[1];
        cpf = new CPF(dados[2]);
        email = new Email(dados[3]);
        endereco = new Endereco(dados[4]);
        telefone = new Telefone(dados[5]);
    }

    public Cliente(String cnh, String nomeCompleto, CPF cpf, Email email, Endereco endereco, Telefone telefone) {
        this.nomeCompleto = nomeCompleto;
        this.cnh = cnh;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getCNH() {
        return cnh;
    }

    public void setCNH(String cnh) {
        this.cnh = cnh;
    }
    
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    
    public CPF getCPF() {
        return cpf;
    }

    public void setCPF(CPF cpf) {
        this.cpf = cpf;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
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

    @Override
    public String toString() {
        return cnh + "|"
                + nomeCompleto + "|"
                + cpf.toString() + "|"
                + email.toString() + "|"
                + endereco.toString() + "|"
                + telefone.toString()
                + "\n";
    }

}
