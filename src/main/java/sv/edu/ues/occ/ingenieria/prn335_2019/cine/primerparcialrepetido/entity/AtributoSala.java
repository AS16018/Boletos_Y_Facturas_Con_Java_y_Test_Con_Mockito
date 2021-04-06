/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author jcpenya
 */
@Entity
@Table(name = "atributo_sala", catalog = "cine", schema = "")
@NamedQueries({
    @NamedQuery(name = "AtributoSala.findAll", query = "SELECT a FROM AtributoSala a"),
    @NamedQuery(name = "AtributoSala.findByIdCaracteristica", query = "SELECT a FROM AtributoSala a WHERE a.atributoSalaPK.idCaracteristica = :idCaracteristica"),
    @NamedQuery(name = "AtributoSala.findByIdSala", query = "SELECT a FROM AtributoSala a WHERE a.atributoSalaPK.idSala = :idSala"),
    @NamedQuery(name = "AtributoSala.findByValor", query = "SELECT a FROM AtributoSala a WHERE a.valor = :valor")})
public class AtributoSala implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AtributoSalaPK atributoSalaPK;
    @Basic(optional = false)
    @Column(name = "valor", nullable = false)
    private int valor;
    @JoinColumn(name = "id_caracteristica", referencedColumnName = "id_caracteristica", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CaracteristicaSala caracteristicaSala;
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sala sala;

    public AtributoSala() {
    }

    public AtributoSala(AtributoSalaPK atributoSalaPK) {
        this.atributoSalaPK = atributoSalaPK;
    }

    public AtributoSala(AtributoSalaPK atributoSalaPK, int valor) {
        this.atributoSalaPK = atributoSalaPK;
        this.valor = valor;
    }

    public AtributoSala(int idCaracteristica, int idSala) {
        this.atributoSalaPK = new AtributoSalaPK(idCaracteristica, idSala);
    }

    public AtributoSalaPK getAtributoSalaPK() {
        return atributoSalaPK;
    }

    public void setAtributoSalaPK(AtributoSalaPK atributoSalaPK) {
        this.atributoSalaPK = atributoSalaPK;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public CaracteristicaSala getCaracteristicaSala() {
        return caracteristicaSala;
    }

    public void setCaracteristicaSala(CaracteristicaSala caracteristicaSala) {
        this.caracteristicaSala = caracteristicaSala;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atributoSalaPK != null ? atributoSalaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtributoSala)) {
            return false;
        }
        AtributoSala other = (AtributoSala) object;
        if ((this.atributoSalaPK == null && other.atributoSalaPK != null) || (this.atributoSalaPK != null && !this.atributoSalaPK.equals(other.atributoSalaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ues.occ.ingenieria.prn335_2019.cine.cinedestkop.entity.AtributoSala[ atributoSalaPK=" + atributoSalaPK + " ]";
    }
    
}
