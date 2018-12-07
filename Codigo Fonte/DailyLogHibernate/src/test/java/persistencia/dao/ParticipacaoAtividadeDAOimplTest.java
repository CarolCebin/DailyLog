package persistencia.dao;

import modelo.ParticipacaoAtividade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipacaoAtividadeDAOimplTest {

    @Test
    void confirmarParticipacao(){
        ParticipacaoAtividade participacao = new ParticipacaoAtividade();
        ParticipacaoAtividadeDAOimpl  parCOn = new ParticipacaoAtividadeDAOimpl();
        try{
            participacao = parCOn.buscarObjetoID(participacao.getClass(), "02");
            participacao.setConfirmado(true);
            try {
                parCOn.alterar(participacao);
            }catch (Exception e){
                fail("Erro ao confirmar a participacao");
            }

        }catch (Exception e){
            fail("Nao foi possivel encontrar a participacao atividade");
        }finally {
            parCOn.close();
        }
    }

}