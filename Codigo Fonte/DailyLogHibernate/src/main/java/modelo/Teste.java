package modelo;


import persistencia.dao.CategoriaDAOImpl;
import persistencia.dao.GenericoDAOImpl;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        GenericoDAOImpl a = new GenericoDAOImpl();
        a.close();
    }
}
