package data.persistence;

import data.classes.vehicle.Veiculo;
import data.interfaces.CRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class VeiculoDAO implements CRUD {
    String pastaArquivos = "C:\\Users\\gguui\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoLocadoraVeiculos\\src\\files\\";
    String arquivoVeiculos = pastaArquivos + "Veiculos.csv";
    
    @Override
    public void incluir(Object objeto) throws Exception {
        Veiculo veiculo = (Veiculo) objeto;
        FileWriter veiculoFileWriter = null;
        BufferedWriter veiculoBufferedWriter = null;
        try {
            if (exists(veiculo.getPlaca())) throw new Exception("Veículo existente.");
            veiculoFileWriter = new FileWriter(arquivoVeiculos, true);
            veiculoBufferedWriter = new BufferedWriter(veiculoFileWriter);
            veiculoBufferedWriter.write(veiculo.toString());
        } catch (IOException ex) {
            throw new Exception("Falha ao incluir o Veículo.\n\n" + ex.getMessage());
        } finally {
            if (veiculoBufferedWriter != null) {
                veiculoBufferedWriter.close();
            }
            if (veiculoFileWriter != null) {
                veiculoFileWriter.close();
            }
        }
    }

    @Override
    public void remover(Object objeto) throws Exception {
        Veiculo veiculoExistente = (Veiculo) objeto;
        FileWriter veiculoFileWriter = null;
        BufferedWriter veiculoBufferedReader = null;
        try {
            if (!exists(veiculoExistente.getPlaca())) throw new Exception("Veículo inexistente.");
            if (new LocacaoDAO().existsByPlaca(veiculoExistente.getPlaca())) throw new Exception("Impossível remover um Veículo que já foi Locado.");
            ArrayList<Veiculo> veiculos = listar();
            veiculoFileWriter = new FileWriter(arquivoVeiculos, false);
            veiculoBufferedReader = new BufferedWriter(veiculoFileWriter);
            for (Veiculo veiculo : veiculos) {
                if (!veiculo.getPlaca().equals(veiculoExistente.getPlaca())) {
                    veiculoBufferedReader.write(veiculo.toString());
                }
            }
        } catch (Exception ex) {
            throw new Exception("Falha ao remover o Veículo.\n\n" + ex.getMessage());
        } finally {
            if (veiculoBufferedReader != null) {
                veiculoBufferedReader.close();
            }
            if (veiculoFileWriter != null) {
                veiculoFileWriter.close();
            }
        }
    }
    
    @Override
    public void alterar(Object objeto) throws Exception {
        Veiculo veiculoExistente = (Veiculo) objeto;
        FileWriter veiculoFileWriter = null;
        BufferedWriter veiculoBufferedWriter = null;
        try {
            if (!exists(veiculoExistente.getPlaca())) throw new Exception("Veículo inexistente.");
            ArrayList<Veiculo> veiculos = listar();
            veiculoFileWriter = new FileWriter(arquivoVeiculos, false);
            veiculoBufferedWriter = new BufferedWriter(veiculoFileWriter);
            for (Veiculo veiculo : veiculos) {
                if (veiculo.getPlaca().equals(veiculoExistente.getPlaca())) {
                    veiculoBufferedWriter.write(veiculoExistente.toString());
                } else {
                    veiculoBufferedWriter.write(veiculo.toString());
                }
            }
        } catch (Exception ex) {
            throw new Exception("Falha ao alterar o Veículo.\n\n" + ex.getMessage());
        } finally {
            if (veiculoBufferedWriter != null) {
                veiculoBufferedWriter.close();
            }
            if (veiculoFileWriter != null) {
                veiculoFileWriter.close();
            }
        }
    }

    @Override
    public ArrayList<Veiculo> listar() throws Exception {
        FileReader veiculoFileReader = null;
        BufferedReader veiculoBufferedReader = null;
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        try {
            if (new File(arquivoVeiculos).exists()) {
                veiculoFileReader = new FileReader(arquivoVeiculos);
                veiculoBufferedReader = new BufferedReader(veiculoFileReader);
                String linha;
                while ((linha = veiculoBufferedReader.readLine()) != null) {
                    Veiculo veiculo = new Veiculo(linha);
                    veiculos.add(veiculo);
                }
            }
        } catch (IOException ex) {
            throw new Exception("Falha ao listar os Veículos.\n\n" + ex.getMessage());
        } finally {
            if (veiculoBufferedReader != null) {
                veiculoBufferedReader.close();
            }
            if (veiculoFileReader != null) {
                veiculoFileReader.close();
            }
        }
        return veiculos;
    }
    
    public Veiculo getByPlaca(String placaVeiculo) throws Exception {
        for (Veiculo veiculo : listar()) {
            if (veiculo.getPlaca().equals(placaVeiculo))
                return veiculo;
        }
        throw new Exception("Veículo inexistente.");
    }
    
    public boolean exists(String placaVeiculo) throws Exception {
        for (Veiculo veiculo : listar()) {
            if (veiculo.getPlaca().equals(placaVeiculo))
                return true;
        }
        return false;
    }
    
    public boolean existsByMarca(String marcaNome) throws Exception {
        for (Veiculo veiculo : listar()) {
            if (veiculo.getMarca().getNome().equals(marcaNome))
                return true;
        }
        return false;
    }
      
    public boolean existsByMarcaModelo(String marcaNome, String modeloNome) throws Exception {
        for (Veiculo veiculo : listar()) {
            if (veiculo.getMarca().getNome().equals(marcaNome) && veiculo.getModelo().getNome().equals(modeloNome))
                return true;
        }
        return false;
    }
}
