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

    @ManyToMany
    @JoinTable(name = "rel_permissao_perfil",
            joinColumns = { @JoinColumn(name = "fk_perfil") },
            inverseJoinColumns = { @JoinColumn(name = "fk_permissao") })
    private List<Permissao> permissoes = new ArrayList<Permissao>();


    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public int getId() {
        return id;
    }

    public void adicionarPermissao(Permissao novaPermissao){
        this.permissoes.add(novaPermissao);
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

    public void setHorarioPadraoInicioString(String horario){
        this.horarioPadraoInicio = LocalTime.parse(horario + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }


    public void setHorarioPadraoTerminoString(String horario){
        this.horarioPadraoTermino = LocalTime.parse(horario + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
