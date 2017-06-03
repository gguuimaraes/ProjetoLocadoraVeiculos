package data.classes;

import java.util.ArrayList;

public class Marca {

    private String nome;
    private ArrayList<String> modelos;

    public Marca() {
    }

    public Marca(String nome) {
        this.nome = nome;
        this.modelos = new ArrayList<>();
    }

    public Marca(String nome, ArrayList<String> modelos) {
        this.nome = nome;
        this.modelos = modelos;
    }
    
    public void incluirModelo(String novoModelo) {
        for (String modelo : this.modelos)
            if (modelo.equalsIgnoreCase(novoModelo)) throw new IllegalArgumentException("O modelo " + novoModelo + " já está incluído na marca " + this.nome + ".");
        this.modelos.add(novoModelo.toUpperCase());
    }
    
    public void removerModelo(String modelo) {
        int indexModelo = this.modelos.indexOf(modelo);
        if (indexModelo == -1) throw new IllegalArgumentException("O modelo " + modelo + " não está incluído na marca " + this.nome + ".");
        this.modelos.remove(indexModelo);
    }
}
