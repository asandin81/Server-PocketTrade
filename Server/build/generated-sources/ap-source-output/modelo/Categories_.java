package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Productes;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-12-14T20:19:56")
@StaticMetamodel(Categories.class)
public class Categories_ { 

    public static volatile CollectionAttribute<Categories, Productes> productesCollection;
    public static volatile SingularAttribute<Categories, Integer> id;
    public static volatile SingularAttribute<Categories, String> nomCategoria;

}