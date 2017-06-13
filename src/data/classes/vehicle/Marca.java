package data.classes.vehicle;

import data.persistence.VeiculoDAO;
import java.util.ArrayList;

public class Marca {

    private String nome;
    private ArrayList<Modelo> modelos;
    private float valor;

    public Marca() {
        modelos = new ArrayList<Modelo>();
    }

    public Marca(String nome, float valor) {
        this.nome = nome;
        modelos = new ArrayList<Modelo>();
        this.valor = valor;
    }

    public Marca(String nome, float valor, ArrayList<Modelo> modelos) {
        this.nome = nome;
        this.modelos = modelos;
        this.valor = valor;
    }
    
    public Marca(String linha) throws Exception {
        String dados[] = linha.split(";");
        if (dados.length != 2) throw new Exception("Dados da marca incorretos.");
        nome = dados[0];
        modelos = new ArrayList<Modelo>();
        valor = Float.parseFloat(dados[1]);
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ArrayList<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<Modelo> modelos) {
        this.modelos = modelos;
    }
    
    public void incluirModelo(Modelo novoModelo) throws Exception {
        for (Modelo modelo : this.modelos) {
            if (modelo.getNome().equals(novoModelo.getNome()))
                throw new Exception("O Modelo " + novoModelo.getNome() + " já está incluído na Marca " + this.nome + ".");
        }
        this.modelos.add(novoModelo);
    }
    
    public void alterarModelo(Modelo modeloAntigo, Modelo modelo) throws Exception {
        for (int indexModelo = 0; indexModelo < this.modelos.size(); indexModelo++) {
            if (modelos.get(indexModelo).getNome().equals(modeloAntigo.getNome())) {
                if (!modeloAntigo.getNome().equals(modelo.getNome()) && new VeiculoDAO().existsByMarcaModelo(nome, modeloAntigo.getNome())) throw new Exception("O Modelo " + modeloAntigo.getNome() + " não pode ser renomeado pois pertence a um Veículo.");
                this.modelos.remove(indexModelo);
                incluirModelo(modelo);
                return;
            }
        }
        throw new Exception("O Modelo " + modeloAntigo.getNome() + " não está incluído na Marca " + this.nome + "."); 
    }

    public void removerModelo(Modelo modeloExistente) throws Exception {
        for (int indexModelo = 0; indexModelo < this.modelos.size(); indexModelo++) {
            if (modelos.get(indexModelo).getNome().equals(modeloExistente.getNome())) {
                if (new VeiculoDAO().existsByMarcaModelo(nome, modeloExistente.getNome())) throw new Exception("O Modelo " + modeloExistente.getNome() + " não pode ser removido pois pertence a um Veículo.");
                this.modelos.remove(indexModelo);
                return;
            }
        }
        throw new Exception("O Modelo " + modeloExistente.getNome() + " não está incluído na Marca " + this.nome + ".");  
    }
    
    @Override
    public String toString() {
        return nome + ";" +
                valor + "\n";
    }
}
