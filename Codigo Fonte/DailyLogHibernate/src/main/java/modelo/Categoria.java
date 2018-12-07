package modelo;

/**
 * @author Ana Carolina Cebin Pereira
 */


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoriaMae", cascade = CascadeType.ALL)
    private List<Categoria> subCategorias = new ArrayList<Categoria>();

    @ManyToOne
    @JoinColumn(name = "fk_categoria_mae")
    private Categoria categoriaMae;

    //Get e Setter padroes

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
        return categoriaMae;
    }

    public void setCategoriaMae(Categoria categoriaMae) {
        this.categoriaMae = categoriaMae;
    }

    //Funcoes especificas da classe

    /**
     * Cria a nova subcategoria e insere na lista de subCategorias
     * @param subCategoria nome da nova SubCategoria
     *
     */
    public void inserirSubCategoria(Categoria subCategoria){
        this.subCategorias.add(subCategoria);
    }

    /**
     * Lista as Subcategorias da categoria
     */
    public void listarSubcategorias(){
        if (!this.subCategorias.isEmpty()){
            for (Categoria subCategoria: this.subCategorias) {
                System.out.println("        Numero: " + subCategoria.getId() +"   Nome: "+ subCategoria.getNome());
            }
        }
    }
}



