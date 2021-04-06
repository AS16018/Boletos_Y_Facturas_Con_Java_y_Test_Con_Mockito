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
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author jcpenya
 */
@Entity
@Table(name = "caracteristica_sala", catalog = "cine", schema = "")
@NamedQueries({
    @NamedQuery(name = "CaracteristicaSala.findAll", query = "SELECT c FROM CaracteristicaSala c"),
    @NamedQuery(name = "CaracteristicaSala.findByIdCaracteristica", query = "SELECT c FROM CaracteristicaSala c WHERE c.idCaracteristica = :idCaracteristica"),
    @NamedQuery(name = "CaracteristicaSala.findByCaracteristica", query = "SELECT c FROM CaracteristicaSala c WHERE c.caracteristica = :caracteristica"),
    @NamedQuery(name = "CaracteristicaSala.findByDescripcion", query = "SELECT c FROM CaracteristicaSala c WHERE c.descripcion = :descripcion")})
public class CaracteristicaSala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_caracteristica", nullable = false)
    private Integer idCaracteristica;
    @Basic(optional = false)
    @Column(name = "caracteristica", nullable = false, length = 300)
    @Size(min = 3, max = 300,message = "Pone cara de chumpe!!! Minimo 3 Maximo 300")
    private String caracteristica;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caracteristicaSala")
    private List<AtributoSala> atributoSalaList;

    public CaracteristicaSala() {
    }

    public CaracteristicaSala(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public CaracteristicaSala(Integer idCaracteristica, String caracteristica, String descripcion) {
        this.idCaracteristica = idCaracteristica;
        this.caracteristica = caracteristica;
        this.descripcion = descripcion;
    }

    public Integer getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<AtributoSala> getAtributoSalaList() {
        return atributoSalaList;
    }

    public void setAtributoSalaList(List<AtributoSala> atributoSalaList) {
        this.atributoSalaList = atributoSalaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaracteristica != null ? idCaracteristica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracteristicaSala)) {
            return false;
        }
        CaracteristicaSala other = (CaracteristicaSala) object;
        if ((this.idCaracteristica == null && other.idCaracteristica != null) || (this.idCaracteristica != null && !this.idCaracteristica.equals(other.idCaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ues.occ.ingenieria.prn335_2019.cine.cinedestkop.entity.CaracteristicaSala[ idCaracteristica=" + idCaracteristica + " ]";
    }

}
