package persistencia.dao;

/**
 * @author Ana Carolina Cebin Pereira
 */

import modelo.Categoria;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaDAOImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * Teste criação de uma nova Categoria e subCategora de uma vez
     */
    @Test
    void populaBancoCategoria() {
        Categoria c1 = new Categoria();
        c1.setNome("Reuniao");

        Categoria c2 = new Categoria();
        c2.setNome("Treinamento");

        Categoria c3 = new Categoria();
        c3.setNome("Comunicacao");

        Categoria c4 = new Categoria();
        c4.setNome("Evento");

        Categoria s1 = new Categoria();
        s1.setNome("PJE");
        s1.setCategoriaMae(c1);

        //Subs
        Categoria s2 = new Categoria();
        s2.setNome("Intranet");
        s2.setCategoriaMae(c1);
        c1.inserirSubCategoria(s2);

        Categoria s3 = new Categoria();
        s3.setNome("Infra");
        s3.setCategoriaMae(c1);
        c1.inserirSubCategoria(s3);

        Categoria s4 = new Categoria();
        s4.setNome("Confraternizacao");
        s4.setCategoriaMae(c4);
        c4.inserirSubCategoria(s4);

        Categoria s5 = new Categoria();
        s5.setNome("Palestra");
        s5.setCategoriaMae(c4);
        c4.inserirSubCategoria(s5);

        Categoria s6 = new Categoria();
        s6.setNome("Email");
        s6.setCategoriaMae(c3);
        c3.inserirSubCategoria(s6);

        Categoria s8 = new Categoria();
        s8.setNome("Despacho");
        s8.setCategoriaMae(c3);
        c3.inserirSubCategoria(s8);

        Categoria s7 = new Categoria();
        s7.setNome("SEI");
        s7.setCategoriaMae(c2);
        c2.inserirSubCategoria(s7);

        Categoria s9 = new Categoria();
        s9.setNome("PJE 2.0");
        s9.setCategoriaMae(c2);
        c2.inserirSubCategoria(s9);

        Categoria s10 = new Categoria();
        s7.setNome("Assyst");
        s7.setCategoriaMae(c2);
        c2.inserirSubCategoria(s10);

        CategoriaDAOImpl con = new CategoriaDAOImpl();

        try{
            con.inserir(c1);
            con.inserir(c2);
            con.inserir(c3);
            con.inserir(c4);
        }catch (Exception e){
            fail("Erro ao inserir a categoria e subcategoria\n Erro: " + e );
        }
        finally {
            con.close();
        }
    }

    @Test
    void listaCetgoriasTest() {
        try{
            CategoriaDAOImpl con = new CategoriaDAOImpl();
            try{
                List<Categoria> categorias = con.listarCategorias();
                for (Categoria categoria: categorias) {
                    System.out.println("Numero: " + categoria.getId() + "   Nome: " + categoria.getNome());
                    categoria.listarSubcategorias();
               }
            }catch (Exception e){
                fail("Erro ao listar as categorias. Erro"+ e);
            }finally {
                con.close();
            }
        }catch (Exception e){
            fail("Erro ao conectar no banco!!!. Erro" + e);
        }
    }

}