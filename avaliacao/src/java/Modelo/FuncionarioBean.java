package Modelo;

import Entidade.Funcionario;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

@ManagedBean
@SessionScoped
public class FuncionarioBean {

    private String nome;
    private String funcao;

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    public void Criar() {
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
}
