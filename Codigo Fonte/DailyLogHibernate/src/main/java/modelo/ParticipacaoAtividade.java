package modelo;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "participacao_atividade")
public class ParticipacaoAtividade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Lob
    @Column(name = "descricao", length = 600)
    private String descricao;
    
    @Column
    private boolean confirmado;
    
    @Column(name = "hr_inicio")
    private LocalTime horarioInicio;
    
    @Column(name = "hr_termino")
    private LocalTime horarioTermino;

    @ManyToOne
    @JoinColumn(name = "fk_atividade")
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    public void setHorarioInicioString(String horario){
        this.horarioInicio = LocalTime.parse(horario + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void setHorarioTerminoString(String horario){
        this.horarioTermino = LocalTime.parse(horario + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(LocalTime horarioTermino) {
        this.horarioTermino = horarioTermino;
    }
    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
