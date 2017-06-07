package data.classes.vehicle;

public class Modelo {
    private String nome;
    private float valor;
    
    public Modelo(String nome, float valor) {
        this.nome = nome;
        this.valor = valor;
    }
    
    public Modelo(String linha) throws Exception {
        String dados[] = linha.split(";");
        if (dados.length != 2) throw new Exception("Dados do modelo incorretos");
        nome = dados[0];
        valor = Float.parseFloat(dados[1]);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return nome + ";" +
                valor + "\n";
    }
}
