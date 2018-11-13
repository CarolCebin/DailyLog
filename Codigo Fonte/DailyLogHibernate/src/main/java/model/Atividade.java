package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "atividade")
public class Atividade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    
    @Column
    private String titulo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_subcategoria")
    private Categoria subCategoria;
    
    @Column
    private String descricao;
    
    @Column(name = "hr_inicio")
    private LocalTime horarioInicio;
    
    @Column(name = "hr_termino")
    private LocalTime horarioTermino;

    @OneToMany(mappedBy = "atividade")
    private List<ParticipacaoAtividade> pessoasParticipantes = new ArrayList<ParticipacaoAtividade>();

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

    public Categoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(Categoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public List<ParticipacaoAtividade> getPessoasParticipantes() {
        return pessoasParticipantes;
    }

    public void setPessoasParticipantes(List<ParticipacaoAtividade> pessoasParticipantes) {
        this.pessoasParticipantes = pessoasParticipantes;
    }

    /*
    public Atividade(String titulo, String descricao, LocalTime horarioInicio, LocalTime horarioTermino) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }
 */
}
