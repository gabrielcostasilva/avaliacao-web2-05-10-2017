package com.grupo1.modelo;

import com.grupo1.entidade.Quarto;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
public class QuartoBean {
    private Long id;
    private Date entrada;
    private Date saida;

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }
    
    
    @PersistenceContext
    private EntityManager em;
            
    @Resource
    private UserTransaction utx;
    
    @PostConstruct
    public void init(){
        em.createQuery("SELECT p FROM Mobilia p");
    }

    
     public String salvar(){
        try {
            Quarto quarto = new Quarto();
            quarto.setEntrada(this.getEntrada());
            quarto.setSaida(this.getSaida());

            utx.begin();
            em.persist(quarto);
            utx.commit();
            
            return "quartoCriado";
        } catch (Exception e) {
            return "cancela";
        }
    }

}
