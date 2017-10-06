package com.webapp2.bean;

import com.webapp2.entidade.Hotel;
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
    
    public String criar() {

        try {
            Hotel h1 = new Hotel();

            h1.setNome("Adilson");
            
            
            Hotel h2 = new Hotel();

            h2.setNome("Jonas");
            
            
            Hotel h3 = new Hotel();

            h3.setNome("Alan");
            

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