package persistencia.DAOImplementacao;


import persistencia.DAOInterface.DAOGenerico;
import org.hibernate.Criteria;
import org.hibernate.Session;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class DAOGenericoImpl<T> implements DAOGenerico<T> {
    EntityManagerFactory emf;
    EntityManager em;

    public DAOGenericoImpl() {
        this.emf = Persistence.createEntityManagerFactory("dailyLog");
        this.em = emf.createEntityManager();
    }

    public void inserir(T objeto) throws Exception {
        this.em.getTransaction().begin();
        this.em.persist(objeto);
        this.em.flush();
        this.em.getTransaction().commit();

    }

    public void alterar(T objeto) throws Exception {
        this.em.getTransaction().begin();
        this.em.merge(objeto);
        this.em.flush();
        this.em.getTransaction().commit();
    }

    public void deletar(T objeto) throws Exception {
        this.em.getTransaction().begin();
        this.em.remove(objeto);
        this.em.flush();
        this.em.getTransaction().commit();
    }

    public List<T> listar(Class clazz) throws Exception {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        query.from(clazz);
        return em.createQuery(query).getResultList();
    }

    public T buscar(Class clazz, String id) throws Exception{
        this.em.getTransaction().begin();
        Object obj =  this.em.find(clazz, new Integer(Integer.parseInt(id)));
        this.em.flush();
        this.em.getTransaction().commit();
        return (T)obj;
    }

    public void fecharSessao(){
        this.emf.close();
    }
}
