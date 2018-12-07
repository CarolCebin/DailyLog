package persistencia.dao;

import modelo.Categoria;
import modelo.Permissao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermissaoDAOImplTest {

    @Test
    void testeCriarPermissao() {
        Permissao p1 = new Permissao();
        p1.setNome("testeFuncaoSalvar");
        PermissaoDAOImpl con = new PermissaoDAOImpl();
        try{
            con.inserir(p1);
        }catch (Exception e){
            fail("Erro ao inserir permissao!!Erro: " + e);
        }finally {
            con.close();
        }
    }

    @Test
    void populaBancoPermissoes() {
        Permissao p1 = new Permissao();
        p1.setNome("Administrador");

        Permissao p2 = new Permissao();
        p2.setNome("Comum");

        Permissao p3 = new Permissao();
        p3.setNome("Cadastro");
        PermissaoDAOImpl con = new PermissaoDAOImpl();
        try {
            con.inserir(p1);
            con.inserir(p2);
            con.inserir(p3);
        }catch (Exception e) {
            fail("Falha ao inserir a permissão no banco");
        }finally {
            con.close();
        }
    }
}