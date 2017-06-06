package data.classes.client;

public class Cliente {

    private String nomeCompleto;
    private String cnh;
    private CPF cpf;
    private Endereco endereco;
    private Telefone telefone;
    private CartaoCredito cartaoCredito;

    public Cliente() {
    }

    public Cliente(String linha) throws Exception {
        String dados[] = linha.split("|");
        if (dados.length != 6) throw new IllegalArgumentException("Dados do cliente incorretos.");
        cnh = dados[0];
        nomeCompleto = dados[1];
        cpf = new CPF(dados[2]);
        endereco = new Endereco(dados[3]);
        telefone = new Telefone(dados[4]);
        cartaoCredito = new CartaoCredito(dados[5]);
    }

    public Cliente(String cnh, String nomeCompleto, CPF cpf, Endereco endereco, Telefone telefone, CartaoCredito cartaoCredito) {
        this.nomeCompleto = nomeCompleto;
        this.cnh = cnh;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cartaoCredito = cartaoCredito;
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

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    @Override
    public String toString() {
        return cnh + "|"
                + nomeCompleto + "|"
                + cpf.toString() + "|"
                + endereco.toString() + "|"
                + telefone.toString() + "|"
                + cartaoCredito.toString()
                + "\n";
    }

}
