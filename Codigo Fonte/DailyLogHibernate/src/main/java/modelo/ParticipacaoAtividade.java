package modelo;

import javax.persistence.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "participacao_atividade")
public class ParticipacaoAtividade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column
    private String titulo;
    
    @Column
    private String descricao;
    
    @Column
    private boolean confirmado;
    
    @Column(name = "hr_inicio")
    private LocalTime horarioInicio;
    
    @Column(name = "hr_termino")
    private LocalTime horarioTermino;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_expediente")
    private Expediente expediente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_atividade")
    private Atividade atividade;

    public boolean isConfirmado() {
        return confirmado;
    }
    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getConfirmado() {
        return confirmado;
    }

    public void setEstadoConfirmacao(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioInicioString(String horario){
        this.horarioInicio = LocalTime.parse(horario + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public LocalTime getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(LocalTime horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public void setHorarioTerminoString(String horario){
        this.horarioTermino = LocalTime.parse(horario + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
