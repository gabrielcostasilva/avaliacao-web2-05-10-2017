package Persistencia;

import Modelo.HospedeBean;

public class HospedePersistencia {

    public static void main(String args) {

        HospedeBean hospede1 = new HospedeBean();
        HospedeBean hospede2 = new HospedeBean();
        HospedeBean hospede3 = new HospedeBean();

        hospede1.setNome("Léo");
        hospede2.setNome("Jean");
        hospede3.setNome("Gabriel");

        hospede1.criar();
        hospede2.criar();
        hospede3.criar();
    }
}
