/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;





import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
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
@Table(name = "botigues")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Botigues.findAll", query = "SELECT b FROM Botigues b")
    , @NamedQuery(name = "Botigues.findById", query = "SELECT b FROM Botigues b WHERE b.id = :id")
    , @NamedQuery(name = "Botigues.findByIdFiscal", query = "SELECT b FROM Botigues b WHERE b.idFiscal = :idFiscal")
    , @NamedQuery(name = "Botigues.findByNomComercial", query = "SELECT b FROM Botigues b WHERE b.nomComercial = :nomComercial")
    , @NamedQuery(name = "Botigues.findByEmail", query = "SELECT b FROM Botigues b WHERE b.email = :email")
    , @NamedQuery(name = "Botigues.login", query = "SELECT b FROM Botigues b WHERE b.email = :email AND b.password = :password")
    , @NamedQuery(name = "Botigues.findByAdmin", query = "SELECT b FROM Botigues b WHERE b.admin = :admin")
    , @NamedQuery(name = "Botigues.findByPassword", query = "SELECT b FROM Botigues b WHERE b.password = :password")})
public class Botigues implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_fiscal")
    private String idFiscal;
    @Basic(optional = false)
    @Column(name = "nom_comercial")
    private String nomComercial;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "descripcio")
    private String descripcio;
    @Basic(optional = false)
    @Column(name = "admin")
    private short admin;
    @Basic(optional = false)
    @Column(name = "password")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;
    @OneToMany(mappedBy = "idBotiga")
    private Collection<Telefons> telefonsCollection;
    @OneToMany(mappedBy = "idBotiga")
    private Collection<Adrecas> adrecasCollection;
   
    

    public Botigues() {
    }

    public Botigues(Integer id) {
        this.id = id;
    }

    public Botigues(String idFiscal, String nomComercial, String email, String descripcio, short admin, String password) {
        
        this.idFiscal = idFiscal;
        this.nomComercial = nomComercial;
        this.email = email;
        this.admin = admin;
        this.descripcio = descripcio;
        this.password = password;
    }
    public Botigues(Integer id, String idFiscal, String nomComercial, String email, String descripcio, short admin, String password) {
        this.id = id;
        this.idFiscal = idFiscal;
        this.nomComercial = nomComercial;
        this.email = email;
        this.admin = admin;
        this.descripcio = descripcio;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdFiscal() {
        return idFiscal;
    }

    public void setIdFiscal(String idFiscal) {
        this.idFiscal = idFiscal;
    }

    public String getNomComercial() {
        return nomComercial;
    }

    public void setNomComercial(String nomComercial) {
        this.nomComercial = nomComercial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public short getAdmin() {
        return admin;
    }

    public void setAdmin(short admin) {
        this.admin = admin;
    }
    @JsonIgnore
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
        if (!(object instanceof Botigues)) {
            return false;
        }
        Botigues other = (Botigues) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Botigues[ id=" + id + " ]";
    }
    

    
}
