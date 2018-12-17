/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author angelsandin
 */
@Entity
@Table(name = "productes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productes.findAll", query = "SELECT p FROM Productes p")
    , @NamedQuery(name = "Productes.findById", query = "SELECT p FROM Productes p WHERE p.productesPK.id = :id")
    , @NamedQuery(name = "Productes.findByNom", query = "SELECT p FROM Productes p WHERE p.nom = :nom")
    , @NamedQuery(name = "Productes.findByPreu", query = "SELECT p FROM Productes p WHERE p.preu = :preu")
    , @NamedQuery(name = "Productes.findByIva", query = "SELECT p FROM Productes p WHERE p.iva = :iva")
    , @NamedQuery(name = "Productes.findByPvp", query = "SELECT p FROM Productes p WHERE p.pvp = :pvp")
    , @NamedQuery(name = "Productes.findByFoto", query = "SELECT p FROM Productes p WHERE p.foto = :foto")
    , @NamedQuery(name = "Productes.findByBotiguesId", query = "SELECT p FROM Productes p WHERE p.productesPK.botiguesId = :botiguesId")
    , @NamedQuery(name = "Productes.findByCategoriesId", query = "SELECT p FROM Productes p WHERE p.productesPK.categoriesId = :categoriesId")})
public class Productes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductesPK productesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 155)
    @Column(name = "nom")
    private String nom;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "descripcio")
    private String descripcio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preu")
    private float preu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva")
    private float iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pvp")
    private float pvp;
    @Size(max = 255)
    @Column(name = "foto")
    private String foto;
    @JoinColumn(name = "categories_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categories categories;

    public Productes() {
    }

    public Productes(ProductesPK productesPK) {
        this.productesPK = productesPK;
    }

    public Productes(ProductesPK productesPK, String nom, float preu, float iva, float pvp) {
        this.productesPK = productesPK;
        this.nom = nom;
        this.preu = preu;
        this.iva = iva;
        this.pvp = pvp;
    }

    public Productes(int id, int botiguesId, int categoriesId) {
        this.productesPK = new ProductesPK(id, botiguesId, categoriesId);
    }

    public ProductesPK getProductesPK() {
        return productesPK;
    }

    public void setProductesPK(ProductesPK productesPK) {
        this.productesPK = productesPK;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productesPK != null ? productesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productes)) {
            return false;
        }
        Productes other = (Productes) object;
        if ((this.productesPK == null && other.productesPK != null) || (this.productesPK != null && !this.productesPK.equals(other.productesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Productes[ productesPK=" + productesPK + " ]";
    }
    
}
