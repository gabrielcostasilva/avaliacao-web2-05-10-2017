package Modelo;

import Entidade.Funcionario;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.constraints.NotNull;

@ManagedBean
@SessionScoped
public class FuncionarioBean {
    
    private String nome;
    @NotNull
    private String funcao;

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    public void criar() {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome(this.nome);
        funcionario.setFuncao(this.funcao);

        try {
            utx.begin();
            em.persist(funcionario);
            utx.commit();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionário");
        }
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

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public UserTransaction getUtx() {
        return utx;
    }

    public void setUtx(UserTransaction utx) {
        this.utx = utx;
    }
    
    
}
