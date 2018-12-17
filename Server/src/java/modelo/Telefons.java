/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author angelsandin
 */
@Entity
@Table(name = "telefons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefons.findAll", query = "SELECT t FROM Telefons t")
    , @NamedQuery(name = "Telefons.findById", query = "SELECT t FROM Telefons t WHERE t.id = :id")
    , @NamedQuery(name = "Telefons.findByTelefon", query = "SELECT t FROM Telefons t WHERE t.telefon = :telefon")})
public class Telefons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "telefon")
    private String telefon;
    @JoinColumn(name = "idClient", referencedColumnName = "id")
    @ManyToOne
    private Clients idClient;
    @JoinColumn(name = "idPropietari", referencedColumnName = "id")
    @ManyToOne
    private Propietaris idPropietari;
    @JoinColumn(name = "idBotiga", referencedColumnName = "id")
    @ManyToOne
    private Botigues idBotiga;

    public Telefons() {
    }

    public Telefons(Integer id) {
        this.id = id;
    }

    public Telefons(Integer id, String telefon) {
        this.id = id;
        this.telefon = telefon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    public Propietaris getIdPropietari() {
        return idPropietari;
    }

    public void setIdPropietari(Propietaris idPropietari) {
        this.idPropietari = idPropietari;
    }

    public Botigues getIdBotiga() {
        return idBotiga;
    }

    public void setIdBotiga(Botigues idBotiga) {
        this.idBotiga = idBotiga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefons)) {
            return false;
        }
        Telefons other = (Telefons) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Telefons[ id=" + id + " ]";
    }
    
}
