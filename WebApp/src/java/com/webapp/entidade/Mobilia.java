package com.webapp.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

@Embeddable
public class Mobilia implements Serializable {
    
    // @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    // private Long id;
    private String descricao;
    
    @DecimalMin ("0.00") @DecimalMax ("1.000")
    private double valor;

    public Mobilia() {
        super();
    }

    public Mobilia(String descricao, double valor) {
        this.setDescricao(descricao);
        this.setValor(valor);
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 53 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Mobilia other = (Mobilia) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        return true;
//    }
    
}
