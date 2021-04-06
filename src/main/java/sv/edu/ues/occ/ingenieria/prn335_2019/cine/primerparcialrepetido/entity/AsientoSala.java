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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "asiento_sala", catalog = "cine", schema = "")
@NamedQueries({
    @NamedQuery(name = "AsientoSala.findAll", query = "SELECT a FROM AsientoSala a"),
    @NamedQuery(name = "AsientoSala.findByIdAsiento", query = "SELECT a FROM AsientoSala a WHERE a.idAsiento = :idAsiento"),
    @NamedQuery(name = "AsientoSala.findByFila", query = "SELECT a FROM AsientoSala a WHERE a.fila = :fila"),
    @NamedQuery(name = "AsientoSala.findByColumna", query = "SELECT a FROM AsientoSala a WHERE a.columna = :columna"),
    @NamedQuery(name = "AsientoSala.findByActivo", query = "SELECT a FROM AsientoSala a WHERE a.activo = :activo")})
public class AsientoSala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_asiento", nullable = false)
    private Integer idAsiento;
    @Basic(optional = false)
    @Column(name = "fila", nullable = false, length = 45)
    private String fila;
    @Basic(optional = false)
    @Column(name = "columna", nullable = false, length = 45)
    private String columna;
    @Basic(optional = false)
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsiento")
    private List<Boleto> boletoList;
    @JoinColumn(name = "id_asiento", referencedColumnName = "id_asiento", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Asiento asiento;
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala", nullable = false)
    @ManyToOne(optional = false)
    private Sala idSala;

    public AsientoSala() {
    }

    public AsientoSala(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public AsientoSala(Integer idAsiento, String fila, String columna, boolean activo) {
        this.idAsiento = idAsiento;
        this.fila = fila;
        this.columna = columna;
        this.activo = activo;
    }

    public Integer getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Boleto> getBoletoList() {
        return boletoList;
    }

    public void setBoletoList(List<Boleto> boletoList) {
        this.boletoList = boletoList;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
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
        if (!(object instanceof AsientoSala)) {
            return false;
        }
        AsientoSala other = (AsientoSala) object;
        if ((this.idAsiento == null && other.idAsiento != null) || (this.idAsiento != null && !this.idAsiento.equals(other.idAsiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.ues.occ.ingenieria.prn335_2019.cine.cinedestkop.entity.AsientoSala[ idAsiento=" + idAsiento + " ]";
    }
    
}
