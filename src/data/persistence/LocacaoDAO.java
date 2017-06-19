package data.persistence;

import data.classes.location.Locacao;
import data.interfaces.CRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LocacaoDAO implements CRUD {

    String pastaArquivos = "files\\";
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
            throw new Exception("Falha ao incluir a Locação.\n\n" + ex.getMessage());
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
    public void alterar(Object objeto) throws Exception {
        Locacao locacaoExistente = (Locacao) objeto;
        FileWriter locacaoFileWriter = null;
        BufferedWriter locacaoBufferedWriter = null;
        try {
            ArrayList<Locacao> locacoes = listar();
            locacaoFileWriter = new FileWriter(arquivoLocacoes, false);
            locacaoBufferedWriter = new BufferedWriter(locacaoFileWriter);
            for (Locacao locacao : locacoes) {
                if (locacao.getDataAbertura().equals(locacaoExistente.getDataAbertura())) {
                    locacaoBufferedWriter.write(locacaoExistente.toString());
                } else {
                    locacaoBufferedWriter.write(locacao.toString());
                }
            }
        } catch (Exception ex) {
            throw new Exception("Falha ao alterar a Locação.\n\n" + ex.getMessage());
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
            throw new Exception("Falha ao listar as Locações.\n\n" + ex.getMessage());
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

    public boolean existsByCNH(String clienteCNH) throws Exception {
        for (Locacao locacao : listar()) {
            if (locacao.getCliente().getCNH().equals(clienteCNH)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean existsAbertaByCNH(String clienteCNH) throws Exception {
        for (Locacao locacao : listar()) {
            if (locacao.getCliente().getCNH().equals(clienteCNH) && locacao.getSituacao() == Locacao.Situacao.ABERTA) {
                return true;
            }
        }
        return false;
    }
    
    public boolean existsByPlaca(String veiculoPlaca) throws Exception {
        for (Locacao locacao : listar()) {
            if (locacao.getVeiculo().getPlaca().equals(veiculoPlaca)) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Locacao> listarByCNH(String clienteCNH) throws Exception {
        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
        for (Locacao locacao : listar()) {
            if (locacao.getCliente().getCNH().equals(clienteCNH)) {
                locacoes.add(locacao);
            }
        }
        return locacoes;
    }
    
    public ArrayList<Locacao> listarAbertasByCNH(String clienteCNH) throws Exception {
        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
        for (Locacao locacao : listarByCNH(clienteCNH)) {
            if (locacao.getCliente().getCNH().equals(clienteCNH) && locacao.getSituacao() == Locacao.Situacao.ABERTA) {
                locacoes.add(locacao);
            }
        }
        return locacoes;
    }
    
    public ArrayList<Locacao> listarByPlaca(String veiculoPlaca) throws Exception {
        ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
        for (Locacao locacao : listar()) {
            if (locacao.getVeiculo().getPlaca().equals(veiculoPlaca)) {
                locacoes.add(locacao);
            }
        }
        return locacoes;
    }
    
    public Locacao getAbertaByPlaca(String veiculoPlaca) throws Exception {
        for (Locacao locacao : listarByPlaca(veiculoPlaca)) {
            if (locacao.getVeiculo().getPlaca().equals(veiculoPlaca) && locacao.getSituacao() == Locacao.Situacao.ABERTA) return locacao;
        }
        return null;
    }
}
