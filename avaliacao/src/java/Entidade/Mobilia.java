package Entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Embeddable
public class Mobilia implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private double valor;
    
    @ManyToOne
    private Quarto quarto;
    
    public Mobilia(){
        super();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Mobilia other = (Mobilia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
