/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author angelsandin
 */
@Embeddable
public class ProductesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "botigues_id")
    private int botiguesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categories_id")
    private int categoriesId;

    public ProductesPK() {
    }

    public ProductesPK(int id, int botiguesId, int categoriesId) {
        this.id = id;
        this.botiguesId = botiguesId;
        this.categoriesId = categoriesId;
    }
    
    public ProductesPK(int botiguesId, int categoriesId) {
        this.botiguesId = botiguesId;
        this.categoriesId = categoriesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBotiguesId() {
        return botiguesId;
    }

    public void setBotiguesId(int botiguesId) {
        this.botiguesId = botiguesId;
    }

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) botiguesId;
        hash += (int) categoriesId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductesPK)) {
            return false;
        }
        ProductesPK other = (ProductesPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.botiguesId != other.botiguesId) {
            return false;
        }
        if (this.categoriesId != other.categoriesId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProductesPK[ id=" + id + ", botiguesId=" + botiguesId + ", categoriesId=" + categoriesId + " ]";
    }
    
}
