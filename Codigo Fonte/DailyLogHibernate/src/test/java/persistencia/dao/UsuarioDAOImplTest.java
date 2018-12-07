package persistencia.dao;

import modelo.Perfil;
import modelo.Permissao;
import modelo.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDAOImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void pupularBancoUsusario() {
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        Usuario u3 = new Usuario();

        u1.setNome("Florzinha");
        u2.setNome("Docinho");
        u3.setNome("Lindinha");

        u1.setSobrenome("Bela");
        u2.setSobrenome("Bela");
        u3.setSobrenome("Bela");

        u1.setLogin("FBELA");
        u2.setLogin("DBELA");
        u3.setLogin("LBELA");

        u1.setSenha("asdas");
        u2.setSenha("sasdf");
        u3.setSenha("Asgdfg");

        Perfil p1 = new Perfil();
        Perfil p2 = new Perfil();
        Perfil p3 = new Perfil();


        p1.setHorarioPadraoInicioString("07:00");
        p1.setHorarioPadraoTerminoString("18:00");
        p1.setAutoContraste(false);
        p1.setTamanhoFonte(10);

        p2.setHorarioPadraoInicioString("13:00");
        p2.setHorarioPadraoTerminoString("18:00");
        p2.setAutoContraste(true);
        p2.setTamanhoFonte(12);

        p3.setHorarioPadraoInicioString("12:00");
        p3.setHorarioPadraoTerminoString("19:00");
        p3.setAutoContraste(true);
        p3.setTamanhoFonte(12);

        PermissaoDAOImpl p = new PermissaoDAOImpl();
        Permissao permissao1 = new Permissao();
        Permissao permissao2 = new Permissao();
        Permissao permissao3 = new Permissao();
        try {
            permissao1 = p.buscarObjetoID(permissao1.getClass(), "01");
            p1.setPermissao(permissao1);
        }catch (Exception e) {
            fail("Falha ao buscar permissao 1 . Erro: " + e);
        }try {

            permissao2 = p.buscarObjetoID(permissao2.getClass(), "02");
            p2.setPermissao(permissao2);
        }catch (Exception e) {
            fail("Falha ao buscar permissao 2. Erro: " + e);
        }
        try {
            permissao3 = p.buscarObjetoID(permissao3.getClass(), "03");
            p3.setPermissao(permissao3);
        }
        catch (Exception e) {
            fail("Falha ao buscar permissao3. Erro: " + e);
        }
        p.close();

        u1.setPerfil(p1);
        u2.setPerfil(p2);
        u3.setPerfil(p3);

        UsuarioDAOImpl userCon = new UsuarioDAOImpl();
        try{
            userCon.inserir(u1);
            try{
                userCon.inserir(u2);
                try{
                    userCon.inserir(u3);
                }catch (Exception e){
                    fail("Usuario 3 nao foi adicionado");
                }
            }catch (Exception e){
                fail("Usuario 2 nao adicionado");
            }
        }catch (Exception e){
            fail("Usuario 1 nao adicionado");
        }finally {
            userCon.close();
        }
    }
}