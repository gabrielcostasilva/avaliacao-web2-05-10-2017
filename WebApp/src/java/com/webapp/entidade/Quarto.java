package com.webapp.entidade;

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
import javax.validation.constraints.Future;

@Entity
public class Quarto implements Serializable {
    
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal (TemporalType.DATE)
    private Date entrada;
    
    @Temporal (TemporalType.DATE) @Future
    private Date saida;
    
    @OneToMany
    private List<Hospede> hospedes;
    
    @ElementCollection
    private List<Mobilia> mobilia;

    public Quarto(Date entrada, Date saida, List<Mobilia> mobilia, List<Hospede> hospedes) {
        this.setEntrada(entrada);
        this.setSaida(saida);
        this.setMobilia(mobilia);
        this.setHospedes(hospedes);
    }

    public List<Mobilia> getMobilia() {
        return mobilia;
    }

    public void setMobilia(List<Mobilia> mobilia) {
        this.mobilia = mobilia;
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Hospede> hospedes) {
        this.hospedes = hospedes;
    }
    
    public Quarto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
