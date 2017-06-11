package data.interfaces;

import java.util.ArrayList;

public interface CRUD {
    void incluir(Object o) throws Exception;
    void remover(Object o) throws Exception;
    void alterar(Object o) throws Exception;
    ArrayList<?> listar() throws Exception;
}
