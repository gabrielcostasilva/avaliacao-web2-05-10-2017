package com.webapp2.bean;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.constraints.Size;

@ManagedBean
public class HotelBean {
  
    @Size(min=3, max=15)
    private String nome;
        
    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}