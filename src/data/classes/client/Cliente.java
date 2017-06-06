package data.classes.client;

public class Cliente {

    private String nomeCompleto;
    private long cnh;
    private CPF cpf;
    private Endereco endereco;
    private Telefone telefone;
    private CartaoCredito cartaoCredito;

    public Cliente() {
    }

    public Cliente(String linha) throws Exception {
        String dados[] = linha.split("|");
        if (dados.length != 6) throw new IllegalArgumentException("Dados do cliente incorretos.");
        nomeCompleto = dados[0];
        cnh = Long.parseLong(dados[1]);
        cpf = new CPF(dados[2]);
        endereco = new Endereco(dados[3]);
        telefone = new Telefone(dados[4]);
        cartaoCredito = new CartaoCredito(dados[5]);
    }

    public Cliente(String nomeCompleto, long cnh, CPF cpf, Endereco endereco, Telefone telefone, CartaoCredito cartaoCredito) {
        this.nomeCompleto = nomeCompleto;
        this.cnh = cnh;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cartaoCredito = cartaoCredito;
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

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    @Override
    public String toString() {
        return nomeCompleto + "|"
                + cnh + "|"
                + cpf.toString() + "|"
                + endereco.toString() + "|"
                + telefone.toString() + "|"
                + cartaoCredito.toString()
                + "\n";
    }

}
