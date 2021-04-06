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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jcpenya
 */
@Entity
@Table(name = "caracteristica_funcion", catalog = "cine", schema = "")
@NamedQueries({
    @NamedQuery(name = "CaracteristicaFuncion.findAll", query = "SELECT c FROM CaracteristicaFuncion c"),
    @NamedQuery(name = "CaracteristicaFuncion.findByIdCaracteristica", query = "SELECT c FROM CaracteristicaFuncion c WHERE c.idCaracteristica = :idCaracteristica"),
    @NamedQuery(name = "CaracteristicaFuncion.findByCaracteristica", query = "SELECT c FROM CaracteristicaFuncion c WHERE c.caracteristica = :caracteristica"),
    @NamedQuery(name = "CaracteristicaFuncion.findByDescripcion", query = "SELECT c FROM CaracteristicaFuncion c WHERE c.descripcion = :descripcion")})
public class CaracteristicaFuncion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_caracteristica", nullable = false)
    private Integer idCaracteristica;
    @Basic(optional = false)
    @Column(name = "caracteristica", nullable = false, length = 300)
    private String caracteristica;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caracteristicaFuncion")
    private List<AtributoFuncion> atributoFuncionList;

    public CaracteristicaFuncion() {
    }

    public CaracteristicaFuncion(Integer idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public CaracteristicaFuncion(Integer idCaracteristica, String caracteristica, String descripcion) {
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

    public List<AtributoFuncion> getAtributoFuncionList() {
        return atributoFuncionList;
    }

    public void setAtributoFuncionList(List<AtributoFuncion> atributoFuncionList) {
        this.atributoFuncionList = atributoFuncionList;
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
        if (!(object instanceof CaracteristicaFuncion)) {
            return false;
        }
        CaracteristicaFuncion other = (CaracteristicaFuncion) object;
        if ((this.idCaracteristica == null && other.idCaracteristica != null) || (this.idCaracteristica != null && !this.idCaracteristica.equals(other.idCaracteristica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ues.occ.ingenieria.prn335_2019.cine.cinedestkop.entity.CaracteristicaFuncion[ idCaracteristica=" + idCaracteristica + " ]";
    }
    
}
