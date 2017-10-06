package Persistencia;

import Modelo.HotelBean;

public class HotelPersistencia {

    public static void main(String args) {

        HotelBean hotel1 = new HotelBean();
        HotelBean hotel2 = new HotelBean();
        HotelBean hotel3 = new HotelBean();

        hotel1.setNome("Trivago");
        hotel2.setNome("Hotel Urbano");
        hotel3.setNome("Dona Maria");

        hotel1.criar();
        hotel2.criar();
        hotel3.criar();
    }
}
