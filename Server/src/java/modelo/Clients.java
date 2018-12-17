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
 * @author Angel Sandin
 */
@Entity
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c")
    , @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id")
    , @NamedQuery(name = "Clients.findByNom", query = "SELECT c FROM Clients c WHERE c.nom = :nom")
    , @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email")
    , @NamedQuery(name = "Clients.login", query = "SELECT c FROM Clients c WHERE c.email = :email AND c.password = :password")
    , @NamedQuery(name = "Clients.findByCognoms", query = "SELECT c FROM Clients c WHERE c.cognoms = :cognoms")
    , @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email")
    , @NamedQuery(name = "Clients.findByPassword", query = "SELECT c FROM Clients c WHERE c.password = :password")})
public class Clients implements Serializable {

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
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "idClient")
    private Collection<Telefons> telefonsCollection;
    @OneToMany(mappedBy = "idClient")
    private Collection<Adrecas> adrecasCollection;

    public Clients() {
    }

    public Clients(Integer id) {
        this.id = id;
    }
    public Clients(Integer id, String nom, String cognoms, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
        this.password = password;
    }

    public Clients(String nom, String cognoms, String email, String password) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Clients[ id=" + id + " ]";
    }
    
}
