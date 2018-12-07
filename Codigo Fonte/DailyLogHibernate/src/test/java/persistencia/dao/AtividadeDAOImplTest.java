package persistencia.dao;

import modelo.Atividade;
import modelo.Categoria;
import modelo.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class AtividadeDAOImplTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void popularBancoAtividade(){
        Atividade atividade = new Atividade();

        CategoriaDAOImpl catCon = new CategoriaDAOImpl();
        try{
            Categoria cat = new Categoria();
            cat = catCon.buscarObjetoID(cat.getClass(), "12");
            atividade.setSubCategoria(cat);
        }catch (Exception e){
            fail("Erro ao buscar subcatgeoria. Erro:" + e);
        }

        atividade.setDescricao("Aniversariantes do mes de novembro no 16 andar. ");
        atividade.setHorarioInicioString("16:00");
        atividade.setHorarioTerminoString("17:30");
        atividade.setTitulo("Aniversariantes mes de Novembro");
        atividade.setDataString("12/08/2018");

        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        Usuario u3 = new Usuario();

        UsuarioDAOImpl useCon = new UsuarioDAOImpl();
        try {
            u1 = useCon.buscarObjetoID(u1.getClass(),"01");
        }catch (Exception e){
            fail("nao foi possivel encontrar o usuario");
        }
        try {
            u2 = useCon.buscarObjetoID(u1.getClass(),"02");
        }catch (Exception e){
            fail("nao foi possivel encontrar o usuario");
        }
        try {
            u3 = useCon.buscarObjetoID(u1.getClass(),"03");
        }catch (Exception e){
            fail("nao foi possivel encontrar o usuario");
        }

        List<Usuario> participantes = new ArrayList<>();
        participantes.add(u1);
        participantes.add(u2);
        participantes.add(u3);

        atividade.criaParticipacoesAtividade(participantes);
        atividade.setUsuario(u1);

        AtividadeDAOImpl atiCon = new AtividadeDAOImpl();
        try {
            atiCon.inserir(atividade);
        }catch (Exception e){
            fail("Erro ao salvar atividade: " + e);
        }
    }
}