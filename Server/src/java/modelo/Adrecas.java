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
@Table(name = "adrecas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adrecas.findAll", query = "SELECT a FROM Adrecas a")
    , @NamedQuery(name = "Adrecas.findById", query = "SELECT a FROM Adrecas a WHERE a.id = :id")
    , @NamedQuery(name = "Adrecas.findByCarrer", query = "SELECT a FROM Adrecas a WHERE a.carrer = :carrer")
    , @NamedQuery(name = "Adrecas.findByNumero", query = "SELECT a FROM Adrecas a WHERE a.numero = :numero")
    , @NamedQuery(name = "Adrecas.findByPoblacio", query = "SELECT a FROM Adrecas a WHERE a.poblacio = :poblacio")
    , @NamedQuery(name = "Adrecas.findByCp", query = "SELECT a FROM Adrecas a WHERE a.cp = :cp")
    , @NamedQuery(name = "Adrecas.findByComarca", query = "SELECT a FROM Adrecas a WHERE a.comarca = :comarca")
    , @NamedQuery(name = "Adrecas.findByPais", query = "SELECT a FROM Adrecas a WHERE a.pais = :pais")})
public class Adrecas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "carrer")
    private String carrer;
    @Column(name = "numero")
    private String numero;
    @Column(name = "poblacio")
    private String poblacio;
    @Column(name = "cp")
    private String cp;
    @Column(name = "comarca")
    private String comarca;
    @Column(name = "pais")
    private String pais;
    @JoinColumn(name = "idBotiga", referencedColumnName = "id")
    @ManyToOne
    private Botigues idBotiga;
    @JoinColumn(name = "idClient", referencedColumnName = "id")
    @ManyToOne
    private Clients idClient;
    @JoinColumn(name = "idPropietari", referencedColumnName = "id")
    @ManyToOne
    private Propietaris idPropietari;

    public Adrecas() {
    }

    public Adrecas(Integer id) {
        this.id = id;
    }

    public Adrecas(Integer id, String carrer) {
        this.id = id;
        this.carrer = carrer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarrer() {
        return carrer;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Botigues getIdBotiga() {
        return idBotiga;
    }

    public void setIdBotiga(Botigues idBotiga) {
        this.idBotiga = idBotiga;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adrecas)) {
            return false;
        }
        Adrecas other = (Adrecas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Adrecas[ id=" + id + " ]";
    }
    
}
