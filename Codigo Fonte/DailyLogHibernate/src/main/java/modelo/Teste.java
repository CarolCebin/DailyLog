package modelo;


import persistencia.implementacaoDAO.genericoImplGenericoDAO;

public class Teste {
    public static void main(String[] args) throws Exception {


        genericoImplGenericoDAO conexao = new genericoImplGenericoDAO();
        conexao.fecharSessao();

    }
}
