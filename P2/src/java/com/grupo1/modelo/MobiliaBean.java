
package com.grupo1.modelo;

import com.grupo1.entidade.Mobilia;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
public class MobiliaBean {
    
    private Long id;
    private String descricao;
    private float valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
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
            Mobilia mobilia = new Mobilia();
            mobilia.setDescricao(this.getDescricao());
            mobilia.setValor(this.getValor());

            utx.begin();
            em.persist(mobilia);
            utx.commit();
            
            return "mobiliaCriado";
        } catch (Exception e) {
            return "cancela";
        }
    }
    
}
