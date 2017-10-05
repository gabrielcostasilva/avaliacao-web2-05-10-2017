/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidade.Quarto;
import java.util.Date;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
@SessionScoped
public class QuartoBean {
    
    private Date entrada;
    private Date saida;
    
    @Resource
    private UserTransaction utx;
    @PersistenceContext
    private EntityManager em;
    
    
    public void criar(){
        
        Quarto quarto = new Quarto();
        
        quarto.setEntrada(this.entrada);
        quarto.setSaida(this.saida);
        
        
        try {
            
            utx.begin();
            em.persist(quarto);
            utx.commit();  
            
        } catch (Exception e) {
        }
        
        
        
    }

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

    public UserTransaction getUtx() {
        return utx;
    }

    public void setUtx(UserTransaction utx) {
        this.utx = utx;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
    
}
