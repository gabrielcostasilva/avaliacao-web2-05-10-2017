package Persistencia;

import Modelo.QuartoBean;
import java.util.Date;

public class QuartoPersistencia {

    public static void main(String args) {

        QuartoBean quarto1 = new QuartoBean();
        QuartoBean quarto2 = new QuartoBean();
        QuartoBean quarto3 = new QuartoBean();

        quarto1.setEntrada(new Date(10, 11, 2017));
        quarto1.setSaida(new Date(10, 11, 2017));
        
        quarto2.setEntrada(new Date(10, 11, 2017));
        quarto2.setSaida(new Date(10, 11, 2017));
        
        quarto3.setEntrada(new Date(10, 11, 2017));
        quarto3.setSaida(new Date(10, 11, 2017));

        quarto1.criar();
        quarto2.criar();
        quarto3.criar();
    }
}
