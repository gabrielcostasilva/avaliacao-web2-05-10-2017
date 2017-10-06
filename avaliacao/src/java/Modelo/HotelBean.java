
package Modelo;


import Entidade.Hotel;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class HotelBean {
    
    @Size(min=3,max=15)
    private String nome;
    
    
    @Resource
    private UserTransaction utx;
    @PersistenceContext
    private EntityManager em;
    
    
    public void criar(){
        
        Hotel hotel = new Hotel();
        
        hotel.setNome(this.nome);
        
        
        try {
            
            utx.begin();
            em.persist(hotel);
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
