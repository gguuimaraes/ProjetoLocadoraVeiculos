package data.persistence;

import data.classes.vehicle.Marca;
import data.classes.vehicle.Modelo;
import data.interfaces.CRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MarcaDAO implements CRUD {

    String pastaArquivos = "C:\\Users\\gguui\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoLocadoraVeiculos\\src\\files\\";
    String arquivoMarcas = pastaArquivos + "Marcas.csv";
    String arquivoModelos = pastaArquivos + "Modelos.csv";

    @Override
    public void incluir(Object objeto) throws Exception {
        Marca marca = (Marca) objeto;
        FileWriter marcaFileWriter = null;
        BufferedWriter marcaBufferedWriter = null;
        FileWriter modeloFileWriter = null;
        BufferedWriter modeloBufferedWriter = null;
        try {
            if (exists(marca.getNome())) throw new Exception("Marca existente.");
            marcaFileWriter = new FileWriter(arquivoMarcas, true);
            marcaBufferedWriter = new BufferedWriter(marcaFileWriter);
            modeloFileWriter = new FileWriter(arquivoModelos, true);
            modeloBufferedWriter = new BufferedWriter(modeloFileWriter);
            marcaBufferedWriter.write(marca.toString());
            for (Modelo modelo : marca.getModelos()) {
                modeloBufferedWriter.write(marca.getNome() + ";" + modelo.toString());
            }
        } catch (IOException ex) {
            throw new Exception("Falha ao incluir a marca.\n\n" + ex);
        } finally {
            if (modeloBufferedWriter != null) {
                modeloBufferedWriter.close();
            }
            if (modeloFileWriter != null) {
                modeloFileWriter.close();
            }
            if (marcaBufferedWriter != null) {
                marcaBufferedWriter.close();
            }
            if (marcaFileWriter != null) {
                marcaFileWriter.close();
            }
        }
    }

    @Override
    public void remover(Object objeto) throws Exception {
        Marca marcaExistente = (Marca) objeto;
        FileWriter marcaFileWriter = null;
        BufferedWriter marcaBufferedWriter = null;
        FileReader modeloFileReader = null;
        BufferedReader modeloBufferedReader = null;
        FileWriter modeloFileWriter = null;
        BufferedWriter modeloBufferedWriter = null;
        try {
            if (!exists(marcaExistente.getNome())) throw new Exception("Marca inexistente.");
            if (new VeiculoDAO().existsByMarca(marcaExistente.getNome())) throw new Exception("Impossível remover uma marca de um veículo cadastrado.");
            ArrayList<Marca> marcas = listar();
            marcaFileWriter = new FileWriter(arquivoMarcas, false);
            marcaBufferedWriter = new BufferedWriter(marcaFileWriter);
            for (Marca marca : marcas) {
                if (!marca.getNome().equals(marcaExistente.getNome())) {
                    marcaBufferedWriter.write(marca.toString());
                }
            }
            if (new File(arquivoModelos).exists()) {
                modeloFileReader = new FileReader(arquivoModelos);
                modeloBufferedReader = new BufferedReader(modeloFileReader);
                modeloFileWriter = new FileWriter(arquivoModelos, false);
                modeloBufferedWriter = new BufferedWriter(modeloFileWriter);
                String linha;
                while ((linha = modeloBufferedReader.readLine()) != null) {
                    String nome = linha.substring(0, linha.indexOf(";"));
                    if (!nome.equals(marcaExistente.getNome())) modeloBufferedWriter.write(linha);
                }
            }
        } catch (Exception ex) {
            throw new Exception("Falha ao remover a marca.\n\n" + ex);
        } finally {
            if (modeloBufferedReader != null) {
                modeloBufferedReader.close();
            }
            if (modeloFileReader != null) {
                modeloFileReader.close();
            }
            if (modeloBufferedWriter != null) {
                modeloBufferedWriter.close();
            }
            if (modeloFileWriter != null) {
                modeloFileWriter.close();
            }
            if (marcaBufferedWriter != null) {
                marcaBufferedWriter.close();
            }
            if (marcaFileWriter != null) {
                marcaFileWriter.close();
            }
        }
    }

    public void alterar(Object objeto) throws Exception {
        Marca marcaAlterada = (Marca) objeto;
        FileWriter marcaFileWriter = null;
        BufferedWriter marcaBufferedWriter = null;
        FileWriter modeloFileWriter = null;
        BufferedWriter modeloBufferedWriter = null;
        try {
            if (!exists(marcaAlterada.getNome())) throw new Exception("Marca inexistente.");
            Marca marcaExistente = getByNome(marcaAlterada.getNome());
            ArrayList<Modelo> modelosRemovidos = new ArrayList<Modelo>();
            for (Modelo modelo : marcaExistente.getModelos()) {
                boolean tem = false;
                for (int indexModelo = 0; indexModelo < marcaAlterada.getModelos().size(); indexModelo++) {
                    if (modelo.getNome().equals(marcaAlterada.getModelos().get(indexModelo).getNome())) {
                        tem = true;
                        indexModelo = marcaAlterada.getModelos().size();
                    }
                    if (!tem) {
                        modelosRemovidos.add(modelo);
                    }
                }
            }
            VeiculoDAO veiculoDAO = new VeiculoDAO();
            for (Modelo modeloRemovido : modelosRemovidos) {
                if (veiculoDAO.existsByMarcaModelo(marcaAlterada.getNome(), modeloRemovido.getNome())) {
                    throw new Exception("O modelo de nome " + modeloRemovido.getNome() + " e valor " + modeloRemovido.getValor() + " não pode ser removido pois pertence a um veículo.");
                }
            }
            ArrayList<Marca> marcas = listar();
            marcaFileWriter = new FileWriter(arquivoMarcas);
            marcaBufferedWriter = new BufferedWriter(marcaFileWriter);
            for (Marca marca : marcas) {
                if (marca.getNome().equals(marcaAlterada.getNome())) {
                    marcaBufferedWriter.write(marcaAlterada.toString());
                } else {
                    marcaBufferedWriter.write(marca.toString());
                }
            }
            if (new File(arquivoModelos).exists()) {
                modeloFileWriter = new FileWriter(arquivoModelos, false);
                modeloBufferedWriter = new BufferedWriter(modeloFileWriter);
                for (Marca marca : marcas) {
                    if (!marca.getNome().equals(marcaAlterada.getNome()))
                        for (Modelo modelo : marca.getModelos()) {
                            modeloBufferedWriter.write(marca.getNome() + ";" + modelo.toString());
                        }
                }
                for (Modelo modelo : marcaAlterada.getModelos()) {
                    modeloBufferedWriter.write(marcaAlterada.getNome() + ";" + modelo.toString());
                }
            }
        } catch (Exception ex) {
            throw new Exception("Falha ao alterar a marca.\n\n" + ex);
        } finally {
            if (modeloBufferedWriter != null) {
                modeloBufferedWriter.close();
            }
            if (modeloFileWriter != null) {
                modeloFileWriter.close();
            }
            if (marcaBufferedWriter != null) {
                marcaBufferedWriter.close();
            }
            if (marcaFileWriter != null) {
                marcaFileWriter.close();
            }
        }
    }

    
    @Override
    public ArrayList<Marca> listar() throws Exception {
        FileReader marcaFileReader = null;
        BufferedReader marcaBufferedReader = null;
        FileReader modeloFileReader = null;
        BufferedReader modeloBufferedReader = null;
        ArrayList<Marca> marcas = new ArrayList<>();
        try {
            if (new File(arquivoMarcas).exists()) {
                marcaFileReader = new FileReader(arquivoMarcas);
                marcaBufferedReader = new BufferedReader(marcaFileReader);
                String linha;
                while ((linha = marcaBufferedReader.readLine()) != null) {
                    Marca marca = new Marca(linha);
                    if (new File(arquivoModelos).exists()) {
                        modeloFileReader = new FileReader(arquivoModelos);
                        modeloBufferedReader = new BufferedReader(modeloFileReader);
                        String subLinha;
                        while ((subLinha = modeloBufferedReader.readLine()) != null) {
                            String nome = subLinha.substring(0, subLinha.indexOf(";"));
                            subLinha = subLinha.substring(subLinha.indexOf(";") + 1);
                            if (nome.equals(marca.getNome())) {
                                marca.incluirModelo(new Modelo(subLinha));
                            }
                        }
                    }
                    marcas.add(marca);
                }
            }
        } catch (IOException ex) {
            throw new Exception("Falha ao listar as marcas.\n\n" + ex);
        } finally {
            if (modeloBufferedReader != null) {
                modeloBufferedReader.close();
            }
            if (modeloFileReader != null) {
                modeloFileReader.close();
            }
            if (marcaBufferedReader != null) {
                marcaBufferedReader.close();
            }
            if (marcaFileReader != null) {
                marcaFileReader.close();
            }
        }
        return marcas;
    }
    
    public Marca getByNome(String nomeMarca) throws Exception {
        for (Marca marca : listar()) {
            if (marca.getNome().equals(nomeMarca))
                return marca;
        }
        throw new Exception("Marca inexistente.");
    }
    
    public Modelo getModeloByNome(String nomeModelo) throws Exception {
        for (Marca marca : listar()) {
            for (Modelo modelo : marca.getModelos()) {
                if (modelo.getNome().equals(nomeModelo)) {
                    return modelo;
                }
            }
        }
        throw new Exception("Modelo do veículo não encontrado.");
    }
    
    public boolean exists(String nomeMarca) throws Exception {
        for (Marca marca : listar()) {
            if (marca.getNome().equals(nomeMarca))
                return true;
        }
        return false;
    }

}
