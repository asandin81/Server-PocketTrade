/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author angelsandin
 */
@Entity
@Table(name = "propietaris")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietaris.findAll", query = "SELECT p FROM Propietaris p")
    , @NamedQuery(name = "Propietaris.findById", query = "SELECT p FROM Propietaris p WHERE p.id = :id")
    , @NamedQuery(name = "Propietaris.findByNom", query = "SELECT p FROM Propietaris p WHERE p.nom = :nom")
    , @NamedQuery(name = "Propietaris.findByCognoms", query = "SELECT p FROM Propietaris p WHERE p.cognoms = :cognoms")
    , @NamedQuery(name = "Propietaris.findByAdreca", query = "SELECT p FROM Propietaris p WHERE p.adreca = :adreca")
    , @NamedQuery(name = "Propietaris.findByTelefon", query = "SELECT p FROM Propietaris p WHERE p.telefon = :telefon")
    , @NamedQuery(name = "Propietaris.findByEmail", query = "SELECT p FROM Propietaris p WHERE p.email = :email")
    , @NamedQuery(name = "Propietaris.findByNif", query = "SELECT p FROM Propietaris p WHERE p.nif = :nif")})
public class Propietaris implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "cognoms")
    private String cognoms;
    @Basic(optional = false)
    @Column(name = "adreca")
    private String adreca;
    @Basic(optional = false)
    @Column(name = "telefon")
    private String telefon;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "NIF")
    private String nif;
    @OneToMany(mappedBy = "idPropietari")
    private Collection<Telefons> telefonsCollection;
    @OneToMany(mappedBy = "idPropietari")
    private Collection<Adrecas> adrecasCollection;

    public Propietaris() {
    }

    public Propietaris(Integer id) {
        this.id = id;
    }

    public Propietaris(Integer id, String nom, String cognoms, String adreca, String telefon, String email, String nif) {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.adreca = adreca;
        this.telefon = telefon;
        this.email = email;
        this.nif = nif;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @XmlTransient
    public Collection<Telefons> getTelefonsCollection() {
        return telefonsCollection;
    }

    public void setTelefonsCollection(Collection<Telefons> telefonsCollection) {
        this.telefonsCollection = telefonsCollection;
    }

    @XmlTransient
    public Collection<Adrecas> getAdrecasCollection() {
        return adrecasCollection;
    }

    public void setAdrecasCollection(Collection<Adrecas> adrecasCollection) {
        this.adrecasCollection = adrecasCollection;
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
        if (!(object instanceof Propietaris)) {
            return false;
        }
        Propietaris other = (Propietaris) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Propietaris[ id=" + id + " ]";
    }
    
}
