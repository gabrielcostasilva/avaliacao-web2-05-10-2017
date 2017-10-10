package com.webapp;

import com.webapp.entidade.Funcionario;
import com.webapp.entidade.Hospede;
import com.webapp.entidade.Hotel;
import com.webapp.entidade.Mobilia;
import com.webapp.entidade.Quarto;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
public class ClasseInicial {
    
    @PersistenceContext
    private EntityManager em;
    
    @Resource
    private UserTransaction utx;
    
    @PostConstruct
    public void init() {
        
        try {
            Funcionario f1 = new Funcionario("John", "Faxineiro"); 
            Funcionario f2 = new Funcionario("Adam", "Atendente"); 
            Funcionario f3 = new Funcionario("Benny", "Ascensorista"); 
            
            utx.begin();
            em.persist(f1);
            utx.commit();
            
            utx.begin();
            em.persist(f2);
            utx.commit();
            
            utx.begin();
            em.persist(f3);
            utx.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Hospede h1 = new Hospede("Bill");
            Hospede h2 = new Hospede("Steave");
            Hospede h3 = new Hospede("Jason");

            utx.begin();
            em.persist(h1);
            utx.commit();

            utx.begin();
            em.persist(h2);
            utx.commit();

            utx.begin();
            em.persist(h3);
            utx.commit();
            
        } catch (Exception e) {
            System.out.println(e);            
        }
        
        try {
            
            Mobilia m1 = new Mobilia("Guarda-roupa", 0.5);
            Mobilia m2 = new Mobilia("Cama", 0.5);
            Mobilia m3 = new Mobilia("TV", 0.5);
            
            List<Mobilia> mobilia = new ArrayList<>();
            mobilia.add(m1);
            mobilia.add(m2);
            mobilia.add(m3);
            
            List<Hospede> hospedes = em.createQuery("SELECT h FROM Hospede h", Hospede.class).getResultList();
            
            Quarto q1 = new Quarto (new Date(), new GregorianCalendar(2018, 4, 10).getTime(), mobilia, hospedes);
            Quarto q2 = new Quarto (new Date(), new GregorianCalendar(2018, 4, 10).getTime(), mobilia, hospedes);
            Quarto q3 = new Quarto (new Date(), new GregorianCalendar(2018, 4, 10).getTime(), mobilia, hospedes);
            
            utx.begin();
            em.persist(q1);
            utx.commit();
            
            utx.begin();
            em.persist(q2);
            utx.commit();
            
            utx.begin();
            em.persist(q3);
            utx.commit();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            
            List<Funcionario> funcionarios = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
            List<Quarto> quartos = em.createQuery("SELECT q FROM Quarto q", Quarto.class).getResultList();
            
            Hotel h1 = new Hotel("Royal Palace", funcionarios, quartos);
            Hotel h2 = new Hotel("Imperial Hotel", funcionarios, quartos);
            Hotel h3 = new Hotel("Sleep in", funcionarios, quartos);
            
            utx.begin();
            em.persist(h1);
            utx.commit();
            
            utx.begin();
            em.persist(h2);
            utx.commit();
            
            utx.begin();
            em.persist(h3);
            utx.commit();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String hello() {
        return "Hello World!";
    }

}
