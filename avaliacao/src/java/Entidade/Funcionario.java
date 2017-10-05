package Entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Funcionario implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String funcao;
    
    @ManyToMany
    private Hotel hotel;
    
    public Funcionario(){
        super();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
