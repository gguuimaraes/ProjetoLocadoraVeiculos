package data.persistence;

import data.classes.Locacao;
import data.interfaces.CRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LocacaoDAO implements CRUD {

    String pastaArquivos = "C:\\Users\\gguui\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoLocadoraVeiculos\\src\\files\\";
    String arquivoLocacoes = pastaArquivos + "Locacoes.csv";

    @Override
    public void incluir(Object objeto) throws Exception {
        Locacao locacao = (Locacao) objeto;
        FileWriter locacaoFileWriter = null;
        BufferedWriter locacaoBufferedWriter = null;
        try {
            locacaoFileWriter = new FileWriter(arquivoLocacoes, true);
            locacaoBufferedWriter = new BufferedWriter(locacaoFileWriter);
            locacaoBufferedWriter.write(locacao.toString());
        } catch (IOException ex) {
            throw new Exception("Falha ao incluir a locação.\n\n" + ex);
        } finally {
            if (locacaoBufferedWriter != null) {
                locacaoBufferedWriter.close();
            }
            if (locacaoFileWriter != null) {
                locacaoFileWriter.close();
            }
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        throw new UnsupportedOperationException("Ainda não implementado.");
    }

    @Override
    public ArrayList<Locacao> listar() throws Exception {
        FileReader locacaoFileReader = null;
        BufferedReader locacaoBufferedReader = null;
        ArrayList<Locacao> locacoes = new ArrayList<>();
        try {
            if (new File(arquivoLocacoes).exists()) {
                locacaoFileReader = new FileReader(arquivoLocacoes);
                locacaoBufferedReader = new BufferedReader(locacaoFileReader);
                String linha;
                while ((linha = locacaoBufferedReader.readLine()) != null) {
                    Locacao locacao = new Locacao(linha);
                    locacoes.add(locacao);
                }
            }
        } catch (IOException ex) {
            throw new Exception("Falha ao listar as locações.\n\n" + ex);
        } finally {
            if (locacaoBufferedReader != null) {
                locacaoBufferedReader.close();
            }
            if (locacaoFileReader != null) {
                locacaoFileReader.close();
            }
        }
        return locacoes;
    }

}
