/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidade.Mobilia;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@ManagedBean
@SessionScoped
public class MobiliaBean {
    
    
    private String descricao;
    @DecimalMin("0.00")
    @DecimalMax ("1.000")
    private double valor;
    
    @Resource
    private UserTransaction utx;
    @PersistenceContext
    private EntityManager em;
    
    
    public void criar(){
        Mobilia mobilia = new Mobilia();
        
        mobilia.setDescricao(this.descricao);
        mobilia.setValor(this.valor);
        
        try {
            
            utx.begin();
            em.persist(mobilia);
            utx.commit();
            
        } catch (Exception e) {
        }
        
        
        
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
