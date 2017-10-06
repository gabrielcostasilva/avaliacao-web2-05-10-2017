package Persistencia;

import Modelo.MobiliaBean;

public class MobiliaPersistencia {
        public static void main(String args) {

        MobiliaBean mobilia1 = new MobiliaBean();
        MobiliaBean mobilia2 = new MobiliaBean();
        MobiliaBean mobilia3 = new MobiliaBean();

        mobilia1.setDescricao("Top");
        mobilia2.setDescricao("Top");
        mobilia3.setDescricao("Muito top");
        
        mobilia1.setValor(300);
        mobilia2.setValor(400);
        mobilia3.setValor(500);

        mobilia1.criar();
        mobilia2.criar();
        mobilia3.criar();
    }
}
