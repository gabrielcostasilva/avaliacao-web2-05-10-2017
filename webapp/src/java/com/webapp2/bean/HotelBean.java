package com.webapp2.bean;

import com.webapp2.entidade.Hotel;
import javax.faces.bean.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
public class HotelBean {
  
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
    
    public String criar() {

        try {
            Hotel h1 = new Hotel();
            h1.setNome("Lago");
            
            
            Hotel h2 = new Hotel();
            h2.setNome("Praia");
            
            
            Hotel h3 = new Hotel();
            h3.setNome("Ilha");
            

            ut.begin();

            em.persist(h1);
            em.persist(h2);
            em.persist(h3);

            ut.commit();

            return "OK";

        } catch (Exception e) {
        
            return "Erro";
        }
    }
    
    
}