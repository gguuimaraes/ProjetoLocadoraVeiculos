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
    
    
}
