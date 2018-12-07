package persistencia.dao;

import modelo.Categoria;

import java.util.List;

/**
 * @author Ana Carolina Cebin Pereira
 */

public interface CategoriaDAO extends GenericoDAO<Categoria>{
    public List<Categoria> listarCategorias() throws Exception;
}
