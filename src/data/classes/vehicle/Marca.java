package data.classes.vehicle;

import java.util.ArrayList;

public class Marca {

    private String nome;
    private ArrayList<Modelo> modelos;
    private float valor;

    public Marca() {
    }

    public Marca(String nome, float valor) {
        this.nome = nome.toUpperCase();
        modelos = new ArrayList<>();
        this.valor = valor;
    }

    public Marca(String nome, float valor, ArrayList<Modelo> modelos) {
        this.nome = nome.toUpperCase();
        this.modelos = modelos;
        this.valor = valor;
    }
    
    public Marca(String linha) {
        String dados[] = linha.split(";");
        if (dados.length != 2) throw new IllegalArgumentException("Dados da marca incorretos.");
        nome = dados[0];
        modelos = new ArrayList<>();
        valor = Float.parseFloat(dados[1]);
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }
    
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<String> modelos) {
        this.modelos = new ArrayList<>();
        modelos.forEach((modelo) -> {
            modelos.add(modelo.toUpperCase());
        });
    }
    
    public void incluirModelo(Modelo novoModelo) {
        for (Modelo modelo : this.modelos) {
            if (modelo.getNome().equals(novoModelo.getNome()))
                throw new IllegalArgumentException("O modelo " + novoModelo.getNome() + " já está incluído na marca " + this.nome + ".");
        }
        this.modelos.add(novoModelo);
    }
    
    public void removerModelo(Modelo modeloExistente) {
        for (int indexModelo = 0; indexModelo < this.modelos.size(); indexModelo++) {
            if (modelos.get(indexModelo).getNome().equals(modeloExistente.getNome())) {
                this.modelos.remove(indexModelo);
                return;
            }
        }
        throw new IllegalArgumentException("O modelo " + modeloExistente.getNome() + " não está incluído na marca " + this.nome + ".");  
    }
    
    @Override
    public String toString() {
        return nome + ";" +
                valor + "\n";
    }
}
