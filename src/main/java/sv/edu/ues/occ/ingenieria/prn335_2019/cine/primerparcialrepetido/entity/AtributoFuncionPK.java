/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jcpenya
 */
@Embeddable
public class AtributoFuncionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_caracteristica", nullable = false)
    private int idCaracteristica;
    @Basic(optional = false)
    @Column(name = "id_funcion", nullable = false)
    private int idFuncion;

    public AtributoFuncionPK() {
    }

    public AtributoFuncionPK(int idCaracteristica, int idFuncion) {
        this.idCaracteristica = idCaracteristica;
        this.idFuncion = idFuncion;
    }

    public int getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(int idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCaracteristica;
        hash += (int) idFuncion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtributoFuncionPK)) {
            return false;
        }
        AtributoFuncionPK other = (AtributoFuncionPK) object;
        if (this.idCaracteristica != other.idCaracteristica) {
            return false;
        }
        if (this.idFuncion != other.idFuncion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ues.occ.ingenieria.prn335_2019.cine.cinedestkop.entity.AtributoFuncionPK[ idCaracteristica=" + idCaracteristica + ", idFuncion=" + idFuncion + " ]";
    }
    
}
