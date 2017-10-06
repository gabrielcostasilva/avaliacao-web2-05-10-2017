package Persistencia;

import Modelo.FuncionarioBean;

public class FuncionarioPersistencia {

    public static void main(String args) {

        FuncionarioBean funcionario1 = new FuncionarioBean();
        FuncionarioBean funcionario2 = new FuncionarioBean();
        FuncionarioBean funcionario3 = new FuncionarioBean();

        funcionario1.setNome("Léo");
        funcionario2.setNome("Jean");
        funcionario3.setNome("Gabriel");
        funcionario1.setFuncao("Chefe");
        funcionario2.setFuncao("Empregado");
        funcionario3.setFuncao("Camareira");

        funcionario1.criar();
        funcionario2.criar();
        funcionario3.criar();
    }

}
