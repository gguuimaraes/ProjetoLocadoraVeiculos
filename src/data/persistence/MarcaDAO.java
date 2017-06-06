package data.persistence;

import data.classes.vehicle.Marca;
import data.interfaces.CRUD;
import java.util.ArrayList;

public class MarcaDAO implements CRUD {

    String pastaArquivos = "C:\\Users\\gguui\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoLocadoraVeiculos\\src\\files\\";
    String arquivoMarcas = pastaArquivos + "Marcas.csv";
    String arquivoModelos = pastaArquivos + "Modelos.csv";

    @Override
    public void incluir(Object objeto) throws Exception {
        Marca marca = (Marca) objeto;
    }

    @Override
    public void remover(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<?> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
