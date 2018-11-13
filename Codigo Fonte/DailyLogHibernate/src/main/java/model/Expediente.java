/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 *  @author Ana Carolina Cebin Pereira
 *
 */

@Entity
@Table(name = "expediente")
public class Expediente implements Serializable {

    /**
     * Atributos e mapeamento
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @Column
    private LocalDate data;

    @Column(name = "hr_inicio")
    private LocalTime horarioInicio;

    @Column(name = "hr_termino")
    private LocalTime horarioTermino;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "expediente")
    private List<ParticipacaoAtividade> atividades = new ArrayList<ParticipacaoAtividade>();




    public List<ParticipacaoAtividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<ParticipacaoAtividade> atividades) {

        this.atividades = atividades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setDataString(String data){
        this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
}
