
package Modelo;

import Entidade.Hospede;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;

@ManagedBean
@SessionScoped
public class HospedeBean {
    
    @NotNull
    private String nome;
    @Resource
    private UserTransaction utx;
    @PersistenceContext
    private EntityManager em;
    
    
    public void criar(){
        
        Hospede hospede = new Hospede();
        
        hospede.setNome(this.nome);
        
        
        try {
            
            utx.begin();
            em.persist(hospede);
            utx.commit();
            
     
            
        } catch (Exception e) {
        }
        
        
        
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
