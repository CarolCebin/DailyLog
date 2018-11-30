package modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Categoria> subCategorias = new ArrayList<Categoria>();


    @ManyToOne
    @JoinColumn(name = "fk_categoria_mae")
    private Categoria categoria;

    public int getId() {
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

    public List<Categoria> getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(List<Categoria> subCategorias) {
        this.subCategorias = subCategorias;
    }

    public Categoria getCategoriaMae() {
        return categoria;
    }

    public void setCategoriaMae(Categoria categoriaMae) {
        this.categoria = categoriaMae;
    }
}
