package model;


import persistencia.DAOImplementacao.DAOGenericoImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Teste {
    public static void main(String[] args) throws Exception {


        DAOGenericoImpl conexao = new DAOGenericoImpl();
        conexao.fecharSessao();

    }
}
