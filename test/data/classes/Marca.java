package data.classes;

import java.util.ArrayList;

public class Marca {

    private String nome;
    private ArrayList<String> modelos;

    public Marca() {
    }

    public Marca(String nome) {
        this.nome = nome.toUpperCase();
        this.modelos = new ArrayList<>();
    }

    public Marca(String nome, ArrayList<String> modelos) {
        this.nome = nome.toUpperCase();
        this.modelos = modelos;
    }
    
    public void incluirModelo(String novoModelo) {
        this.modelos.stream().filter((modelo) -> (modelo.equalsIgnoreCase(novoModelo))).forEachOrdered((_item) -> {
            throw new IllegalArgumentException("O modelo " + novoModelo + " já está incluído na marca " + this.nome + ".");
        });
        this.modelos.add(novoModelo.toUpperCase());
    }
    
    public void removerModelo(String modelo) {
        int indexModelo = this.modelos.indexOf(modelo);
        if (indexModelo == -1) throw new IllegalArgumentException("O modelo " + modelo + " não está incluído na marca " + this.nome + ".");
        this.modelos.remove(indexModelo);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public ArrayList<String> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<String> modelos) {
        this.modelos = new ArrayList<>();
        modelos.forEach((modelo) -> {
            modelos.add(modelo.toUpperCase());
        });
    }
}
