package Entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Quarto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date entrada;
    @Temporal(TemporalType.DATE)
    private Date saida;
    
    @OneToMany
    private Hospede hospede;
    
    @ElementCollection
    private List<Mobilia> mobilia;
    
    public Quarto(){
        super();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Quarto other = (Quarto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

}
