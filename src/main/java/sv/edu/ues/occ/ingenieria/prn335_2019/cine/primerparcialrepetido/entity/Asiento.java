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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author jcpenya
 */
@Entity
@Table(name = "asiento", catalog = "cine", schema = "")
@NamedQueries({
    @NamedQuery(name = "Asiento.findAll", query = "SELECT a FROM Asiento a"),
    @NamedQuery(name = "Asiento.findByIdAsiento", query = "SELECT a FROM Asiento a WHERE a.idAsiento = :idAsiento"),
    @NamedQuery(name = "Asiento.findByActivo", query = "SELECT a FROM Asiento a WHERE a.activo = :activo")})
public class Asiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asiento", nullable = false)
    private Integer idAsiento;
    @Column(name = "activo")
    private Boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asiento")
    private List<AtributoAsiento> atributoAsientoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "asiento")
    private AsientoSala asientoSala;

    public Asiento() {
    }

    public Asiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Integer getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<AtributoAsiento> getAtributoAsientoList() {
        return atributoAsientoList;
    }

    public void setAtributoAsientoList(List<AtributoAsiento> atributoAsientoList) {
        this.atributoAsientoList = atributoAsientoList;
    }

    public AsientoSala getAsientoSala() {
        return asientoSala;
    }

    public void setAsientoSala(AsientoSala asientoSala) {
        this.asientoSala = asientoSala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsiento != null ? idAsiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asiento)) {
            return false;
        }
        Asiento other = (Asiento) object;
        if ((this.idAsiento == null && other.idAsiento != null) || (this.idAsiento != null && !this.idAsiento.equals(other.idAsiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ues.occ.ingenieria.prn335_2019.cine.cinedestkop.entity.Asiento[ idAsiento=" + idAsiento + " ]";
    }
    
}
