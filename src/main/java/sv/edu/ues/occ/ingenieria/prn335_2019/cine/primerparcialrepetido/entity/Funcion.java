/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jcpenya
 */
@Entity
@Table(name = "funcion", catalog = "cine", schema = "")
@NamedQueries({
    @NamedQuery(name = "Funcion.findAll", query = "SELECT f FROM Funcion f"),
    @NamedQuery(name = "Funcion.findByIdFuncion", query = "SELECT f FROM Funcion f WHERE f.idFuncion = :idFuncion"),
    @NamedQuery(name = "Funcion.findByFecha", query = "SELECT f FROM Funcion f WHERE f.fecha = :fecha")})
public class Funcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_funcion", nullable = false)
    private Integer idFuncion;
    @Basic(optional = false)
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcion")
    private List<AtributoFuncion> atributoFuncionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncion")
    private List<Boleto> boletoList;
    @JoinColumn(name = "id_pelicula", referencedColumnName = "id_pelicula", nullable = false)
    @ManyToOne(optional = false)
    private Pelicula idPelicula;

    public Funcion() {
    }

    public Funcion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Funcion(Integer idFuncion, Date fecha) {
        this.idFuncion = idFuncion;
        this.fecha = fecha;
    }

    public Integer getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Integer idFuncion) {
        this.idFuncion = idFuncion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<AtributoFuncion> getAtributoFuncionList() {
        return atributoFuncionList;
    }

    public void setAtributoFuncionList(List<AtributoFuncion> atributoFuncionList) {
        this.atributoFuncionList = atributoFuncionList;
    }

    public List<Boleto> getBoletoList() {
        return boletoList;
    }

    public void setBoletoList(List<Boleto> boletoList) {
        this.boletoList = boletoList;
    }

    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncion != null ? idFuncion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcion)) {
            return false;
        }
        Funcion other = (Funcion) object;
        if ((this.idFuncion == null && other.idFuncion != null) || (this.idFuncion != null && !this.idFuncion.equals(other.idFuncion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ues.occ.ingenieria.prn335_2019.cine.cinedestkop.entity.Funcion[ idFuncion=" + idFuncion + " ]";
    }
    
}
