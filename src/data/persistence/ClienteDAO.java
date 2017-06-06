package data.persistence;

import data.classes.client.Cliente;
import data.interfaces.CRUD;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class ClienteDAO implements CRUD {

    String pastaArquivos = "C:\\Users\\gguui\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoLocadoraVeiculos\\src\\files\\";
    String arquivoClientes = pastaArquivos + "Clientes.csv";

    @Override
    public void incluir(Object objeto) throws Exception {
        Cliente cliente = (Cliente) objeto;
        FileWriter clienteFileWriter = null;
        BufferedWriter clienteBufferedWriter = null;
        try {
            clienteFileWriter = new FileWriter(arquivoClientes, true);
            clienteBufferedWriter = new BufferedWriter(clienteFileWriter);
            clienteBufferedWriter.write(cliente.toString());
        } catch (Exception ex) {
            throw new Exception("Falha ao incluir o cliente.\n\n" + ex);
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
    public void remover(Object o) throws Exception {

    }

    @Override
    public ArrayList<?> recuperar() throws Exception {
        return new ArrayList<Cliente>();
    }

}
