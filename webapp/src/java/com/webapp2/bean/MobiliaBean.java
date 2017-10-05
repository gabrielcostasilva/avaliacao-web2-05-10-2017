package com.webapp2.bean;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@ManagedBean
public class MobiliaBean {
  
    private String descricao;
    @Min(0) @Max(1000)
    private Double valor;
        
    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
 
    
}