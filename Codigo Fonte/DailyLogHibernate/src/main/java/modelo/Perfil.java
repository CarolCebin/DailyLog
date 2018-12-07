package modelo;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "tamanho_fonte")
    private int tamanhoFonte;

    @Column(name = "auto_contraste")
    private boolean autoContraste;

    @Column(name = "hr_padrao_inicio")
    private LocalTime horarioPadraoInicio;

    @Column(name = "hr_padrao_termino")
    private LocalTime horarioPadraoTermino;

    @OneToOne
    @JoinColumn(name = "fk_permissao")
    private Permissao permissao;

    public void setHorarioPadraoInicioString(String horario){
        this.horarioPadraoInicio = LocalTime.parse(horario + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void setHorarioPadraoTerminoString(String horario){
        this.horarioPadraoTermino = LocalTime.parse(horario + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTamanhoFonte() {
        return tamanhoFonte;
    }

    public void setTamanhoFonte(int tamanhoFonte) {
        this.tamanhoFonte = tamanhoFonte;
    }

    public boolean isAutoContraste() {
        return autoContraste;
    }

    public void setAutoContraste(boolean autoContraste) {
        this.autoContraste = autoContraste;
    }

    public LocalTime getHorarioPadraoInicio() {
        return horarioPadraoInicio;
    }

    public void setHorarioPadraoInicio(LocalTime horarioPadraoInicio) {
        this.horarioPadraoInicio = horarioPadraoInicio;
    }

    public LocalTime getHorarioPadraoTermino() {
        return horarioPadraoTermino;
    }

    public void setHorarioPadraoTermino(LocalTime horarioPadraoTermino) {
        this.horarioPadraoTermino = horarioPadraoTermino;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
}
