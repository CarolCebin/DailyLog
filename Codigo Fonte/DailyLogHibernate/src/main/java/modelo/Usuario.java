package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String  sobrenome;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "login", nullable = false)
    private String login;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_perfil")
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario")
    private List<Expediente> expedientes = new ArrayList<Expediente>();

    @OneToMany(mappedBy = "usuario")
    private List<ParticipacaoAtividade> participacoesAtividade = new ArrayList<ParticipacaoAtividade>();

    @OneToMany(mappedBy = "usuario")
    private List<Atividade> atividades = new ArrayList<Atividade>();

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(List<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<ParticipacaoAtividade> getParticipacoesAtividade() {
        return participacoesAtividade;
    }

    public void setParticipacoesAtividade(List<ParticipacaoAtividade> participacoesAtividade) {
        this.participacoesAtividade = participacoesAtividade;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
}
