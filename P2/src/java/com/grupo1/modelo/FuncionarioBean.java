package com.grupo1.modelo;

import com.grupo1.entidade.Funcionario;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
public class FuncionarioBean {
    
    private Long id;
    private String nome;
    private String funcao;
    
        
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    @PersistenceContext
    private EntityManager em;
            
    @Resource
    private UserTransaction utx;
    
    @PostConstruct
    public void init(){
        em.createQuery("SELECT p FROM Funcionario p");
    }

    
     public String salvar(){
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(this.getNome());
            funcionario.setFuncao(this.getFuncao());

            utx.begin();
            em.persist(funcionario);
            utx.commit();
            
            return "funcionarioCriado";
        } catch (Exception e) {
            return "cancela";
        }
    }
    
    
}
