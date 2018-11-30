package modelo;


import persistencia.implementacaoDAO.genericoImplGenericoDAO;

public class Teste {
    public static void main(String[] args) throws Exception {


        genericoImplGenericoDAO conexao = new genericoImplGenericoDAO();

        Categoria cat = new Categoria();
        cat.setNome("Ana Linda");
        cat.setCategoriaMae(null);

        conexao.inserir(cat);

        conexao.fecharSessao();

    }
}
