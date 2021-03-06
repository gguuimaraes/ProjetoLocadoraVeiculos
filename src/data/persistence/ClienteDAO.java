package data.persistence;

import data.classes.client.Cliente;
import data.interfaces.CRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ClienteDAO implements CRUD {

    String pastaArquivos = "files\\";
    String arquivoClientes = pastaArquivos + "Clientes.csv";

    @Override
    public void incluir(Object objeto) throws Exception {
        Cliente cliente = (Cliente) objeto;
        FileWriter clienteFileWriter = null;
        BufferedWriter clienteBufferedWriter = null;
        try {
            if (exists(cliente.getCNH())) throw new Exception("Cliente existente.");
            clienteFileWriter = new FileWriter(arquivoClientes, true);
            clienteBufferedWriter = new BufferedWriter(clienteFileWriter);
            clienteBufferedWriter.write(cliente.toString());
        } catch (IOException ex) {
            throw new Exception("Falha ao incluir o Cliente.\n\n" + ex.getMessage());
        } finally {
            if (clienteBufferedWriter != null) {
                clienteBufferedWriter.close();
            }
            if (clienteFileWriter != null) {
                clienteFileWriter.close();
            }
        }
    }

    @Override
    public void remover(Object objeto) throws Exception {
        Cliente clienteExistente = (Cliente) objeto;
        FileWriter clienteFileWriter = null;
        BufferedWriter clienteBufferedWriter = null;
        try {
            if (!exists(clienteExistente.getCNH())) throw new Exception("Cliente inexistente.");
            if (new LocacaoDAO().existsByCNH(clienteExistente.getCNH())) throw new Exception("Impossível remover um Cliente que já realizou uma Locação.");
            ArrayList<Cliente> clientes = listar();
            clienteFileWriter = new FileWriter(arquivoClientes, false);
            clienteBufferedWriter = new BufferedWriter(clienteFileWriter);
            for (Cliente cliente : clientes) {
                if (!cliente.getCNH().equals(clienteExistente.getCNH())) {
                    clienteBufferedWriter.write(cliente.toString());
                }
            }
        } catch (Exception ex) {
            throw new Exception("Falha ao remover o Cliente.\n\n" + ex.getMessage());
        } finally {
            if (clienteBufferedWriter != null) {
                clienteBufferedWriter.close();
            }
            if (clienteFileWriter != null) {
                clienteFileWriter.close();
            }
        }
    }

    @Override
    public ArrayList<Cliente> listar() throws Exception {
        FileReader clienteFileReader = null;
        BufferedReader clienteBufferedReader = null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            if (new File(arquivoClientes).exists()) {
                clienteFileReader = new FileReader(arquivoClientes);
                clienteBufferedReader = new BufferedReader(clienteFileReader);
                String linha;
                while ((linha = clienteBufferedReader.readLine()) != null) {
                    Cliente cliente = new Cliente(linha);
                    clientes.add(cliente);
                }
            }
        } catch (IOException ex) {
            throw new Exception("Falha ao listar os Clientes.\n\n" + ex.getMessage());
        } finally {
            if (clienteBufferedReader != null) {
                clienteBufferedReader.close();
            }
            if (clienteFileReader != null) {
                clienteFileReader.close();
            }
        }
        return clientes;
    }
    
    @Override
    public void alterar(Object objeto) throws Exception {
        Cliente clienteExistente = (Cliente) objeto;
        FileWriter clienteFileWriter = null;
        BufferedWriter clienteBufferedWriter = null;
        try {
            if (!exists(clienteExistente.getCNH())) throw new Exception("Cliente inexistente.");
            ArrayList<Cliente> clientes = listar();
            clienteFileWriter = new FileWriter(arquivoClientes, false);
            clienteBufferedWriter = new BufferedWriter(clienteFileWriter);
            for (Cliente cliente : clientes) {
                if (cliente.getCNH().equals(clienteExistente.getCNH())) {
                    clienteBufferedWriter.write(clienteExistente.toString());
                } else {
                    clienteBufferedWriter.write(cliente.toString());
                }
            }
        } catch (Exception ex) {
            throw new Exception("Falha ao alterar o Cliente.\n\n" + ex.getMessage());
        } finally {
            if (clienteBufferedWriter != null) {
                clienteBufferedWriter.close();
            }
            if (clienteFileWriter != null) {
                clienteFileWriter.close();
            }
        }
    }
    
    public Cliente getByCNH(String cnhCliente) throws Exception {
        for (Cliente cliente : listar()) {
            if (cliente.getCNH().equals(cnhCliente))
                return cliente;
        }
        throw new Exception("Cliente inexistente.");
    }
    
    public boolean exists(String cnhCliente) throws Exception {
        for (Cliente cliente : listar()) {
            if (cliente.getCNH().equals(cnhCliente))
                return true;
        }
        return false;
    }
}
