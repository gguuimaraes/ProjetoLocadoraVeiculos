package data.classes;

import java.util.ArrayList;

public class Marca {

    private String nome;
    private ArrayList<Modelo> modelos;

    public Marca() {
    }

    public Marca(String nome) {
        this.nome = nome.toUpperCase();
        this.modelos = new ArrayList<>();
    }

    public Marca(String nome, ArrayList<Modelo> modelos) {
        this.nome = nome.toUpperCase();
        this.modelos = modelos;
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
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
}
