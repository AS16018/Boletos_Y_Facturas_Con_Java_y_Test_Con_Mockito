/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jcpenya
 */
@Entity
@Table(name = "sala", catalog = "cine", schema = "")
@NamedQueries({
    @NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s"),
    @NamedQuery(name = "Sala.findByIdSala", query = "SELECT s FROM Sala s WHERE s.idSala = :idSala"),
    @NamedQuery(name = "Sala.findBySala", query = "SELECT s FROM Sala s WHERE s.sala = :sala")})
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sala", nullable = false)
    private Integer idSala;
    @Basic(optional = false)
    @Column(name = "sala", nullable = false, length = 45)
    private String sala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sala")
    private List<AtributoSala> atributoSalaList;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal", nullable = false)
    @ManyToOne(optional = false)
    private Sucursal idSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSala")
    private List<AsientoSala> asientoSalaList;

    public Sala() {
    }

    public Sala(Integer idSala) {
        this.idSala = idSala;
    }

    public Sala(Integer idSala, String sala) {
        this.idSala = idSala;
        this.sala = sala;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public List<AtributoSala> getAtributoSalaList() {
        return atributoSalaList;
    }

    public void setAtributoSalaList(List<AtributoSala> atributoSalaList) {
        this.atributoSalaList = atributoSalaList;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    public List<AsientoSala> getAsientoSalaList() {
        return asientoSalaList;
    }

    public void setAsientoSalaList(List<AsientoSala> asientoSalaList) {
        this.asientoSalaList = asientoSalaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSala != null ? idSala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.idSala == null && other.idSala != null) || (this.idSala != null && !this.idSala.equals(other.idSala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ues.occ.ingenieria.prn335_2019.cine.cinedestkop.entity.Sala[ idSala=" + idSala + " ]";
    }
    
}
