package com.webapp2.bean;

import com.webapp2.entidade.Mobilia;
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
 
    
        public String criar() {

        try {
            Mobilia m1 = new Mobilia();

            m1.setDescricao("Mesa");
            m1.setValor(10.0);
            
            Mobilia m2 = new Mobilia();

            m2.setDescricao("Mesa");
            m2.setValor(30.0);
            
            Mobilia m3 = new Mobilia();

            m3.setDescricao("Mesa");
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