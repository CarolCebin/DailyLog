package modelo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column(name = "data", nullable = false)
    private LocalDate data;
    
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "fk_subcategoria", nullable = false)
    private Categoria subCategoria;

    @Lob
    @Column(name = "descricao", length = 600)
    private String descricao;
    
    @Column(name = "hr_inicio", nullable = false)
    private LocalTime horarioInicio;
    
    @Column(name = "hr_termino", nullable = false)
    private LocalTime horarioTermino;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL)
    private List<ParticipacaoAtividade> participacoes = new ArrayList<ParticipacaoAtividade>();

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ParticipacaoAtividade> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(List<ParticipacaoAtividade> participacoes) {
        this.participacoes = participacoes;
    }

    public void adicionaParticipacoesAtividade(ParticipacaoAtividade participacao){
        this.participacoes.add(participacao);
    }
    public void setHorarioInicioString(String horario){
        this.horarioInicio = LocalTime.parse(horario + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void setHorarioTerminoString(String horario){
        this.horarioTermino = LocalTime.parse(horario + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void criaParticipacoesAtividade(List<Usuario> usuarios){
        for (Usuario usuario: usuarios) {
            ParticipacaoAtividade participacaoAtividade = new ParticipacaoAtividade();
            participacaoAtividade.setConfirmado(false);
            participacaoAtividade.setAtividade(this);
            participacaoAtividade.setDescricao(this.descricao);
            participacaoAtividade.setHorarioInicio(this.horarioInicio);
            participacaoAtividade.setHorarioTermino(this.horarioTermino);
            participacaoAtividade.setUsuario(usuario);
            adicionaParticipacoesAtividade(participacaoAtividade);
        }
    }
    public void setDataString(String data){
        this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
