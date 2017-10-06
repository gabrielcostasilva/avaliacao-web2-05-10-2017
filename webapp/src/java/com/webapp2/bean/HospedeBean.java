package com.webapp2.bean;

import com.webapp2.entidade.Hospede;
import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;

@ManagedBean
public class HospedeBean {
  
    @NotNull
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
            Hospede h1 = new Hospede();

            h1.setNome("Adilson");
            
            Hospede h2 = new Hospede();

            h2.setNome("Jonas");
            
            
            Hospede h3 = new Hospede();

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
