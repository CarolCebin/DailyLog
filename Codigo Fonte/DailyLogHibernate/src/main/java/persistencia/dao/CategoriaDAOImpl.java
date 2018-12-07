package persistencia.dao;

import modelo.Categoria;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Ana Carolina Cebin Pereira
 */

public class CategoriaDAOImpl extends GenericoDAOImpl<Categoria> implements CategoriaDAO {

    /**
     * Busca as categorias que não tem categoria mae(categoriaMae == NULL).
     * @return Lista com as categorias, e com as subcategorias
     */
    public List<Categoria> listarCategorias() throws Exception{
            //Cria objeto do tipo CriteriaBuilder
            CriteriaBuilder builder = this.em.getCriteriaBuilder();
            //Crio uma CriteriaQuery informando qual sera o retorno esperado, no caso sera Categoria
            CriteriaQuery<Categoria> query = builder.createQuery(Categoria.class);
            //Indico qual sera a a classe da entidade a ser cosultada
            Root<Categoria> from = query.from(Categoria.class);
            TypedQuery<Categoria> typedQuery = this.em.createQuery(query.select(from).where(builder.isNull(from.get("categoriaMae"))));
        return typedQuery.getResultList();
    }
}