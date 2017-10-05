package com.webapp2.bean;

import java.util.Date;
import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.constraints.Future;

@ManagedBean
public class QuartoBean {
  
    private Date entrada;
    @Future
    private Date saida;
        
    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }
}