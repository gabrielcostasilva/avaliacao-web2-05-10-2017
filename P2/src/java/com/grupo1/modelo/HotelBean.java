package com.grupo1.modelo;

import com.grupo1.entidade.Hotel;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
public class HotelBean {
    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @PersistenceContext
    private EntityManager em;
            
    @Resource
    private UserTransaction utx;
    
    @PostConstruct
    public void init(){
        em.createQuery("SELECT p FROM Hotel p");
    }

    
     public String salvar(){
        try {
            Hotel hotel = new Hotel();
            hotel.setNome(this.getNome());

            utx.begin();
            em.persist(hotel);
            utx.commit();
            
            return "hotelCriado";
        } catch (Exception e) {
            return "cancela";
        }
    }
    
}
