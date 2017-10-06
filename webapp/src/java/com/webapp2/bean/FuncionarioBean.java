package com.webapp2.bean;

import com.webapp2.entidade.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
public class FuncionarioBean {
  
    private String nome;
    private String funcao;
        
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    public String criar() {

        try {
            Funcionario f1 = new Funcionario();
            f1.setNome("Adilson");
            f1.setFuncao("Programador");
            
            Funcionario f2 = new Funcionario();
            f2.setNome("Jonas");
            f2.setFuncao("Comerciante");
            
            Funcionario f3 = new Funcionario();
            f3.setNome("Alan");
            f3.setFuncao("Carpinteiro");

            ut.begin();

            em.persist(f1);
            em.persist(f2);
            em.persist(f3);

            ut.commit();

            return "OK";

        } catch (Exception e) {
        
            return "Erro";
        }
    }
    
}
