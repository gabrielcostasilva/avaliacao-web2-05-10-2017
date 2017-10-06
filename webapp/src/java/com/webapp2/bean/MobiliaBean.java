package com.webapp2.bean;

import com.webapp2.entidade.Mobilia;
import javax.faces.bean.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
public class MobiliaBean {
  
    private String descricao;
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
 
    
        public String criar() {

        try {
            Mobilia m1 = new Mobilia();
            m1.setDescricao("Mesa");
            m1.setValor(10.0);
            
            Mobilia m2 = new Mobilia();
            m2.setDescricao("Cadeira");
            m2.setValor(30.0);
            
            Mobilia m3 = new Mobilia();
            m3.setDescricao("Frigobar");
            m3.setValor(20.0);
            

            ut.begin();

            em.persist(m1);
            em.persist(m2);
            em.persist(m3);

            ut.commit();

            return "OK";

        } catch (Exception e) {
        
            return "Erro";
        }
    }
    
}