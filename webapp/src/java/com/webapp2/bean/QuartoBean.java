package com.webapp2.bean;

import com.webapp2.entidade.Quarto;
import javax.faces.bean.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
public class QuartoBean {

    private String entrada;
    private String saida;

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String criar() {

        try {

            ut.begin();

            ut.commit();

            return "OK";

        } catch (Exception e) {

            return "Erro";
        }
    }
}
