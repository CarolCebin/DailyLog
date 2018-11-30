package persistencia.interfaceDAO;

import java.util.List;

public interface GenericoDAO<T> {
    public void inserir(T objeto) throws Exception;
    public void alterar(T objeto) throws Exception;
    public void deletar(T objeto) throws Exception;
    public List<T> listar(Class clazz) throws Exception;
    public T buscar(Class clazz, String id) throws Exception;
}
