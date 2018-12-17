package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Categories;
import modelo.ProductesPK;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-12-14T20:19:56")
@StaticMetamodel(Productes.class)
public class Productes_ { 

    public static volatile SingularAttribute<Productes, String> foto;
    public static volatile SingularAttribute<Productes, String> descripcio;
    public static volatile SingularAttribute<Productes, Float> iva;
    public static volatile SingularAttribute<Productes, Float> preu;
    public static volatile SingularAttribute<Productes, ProductesPK> productesPK;
    public static volatile SingularAttribute<Productes, Float> pvp;
    public static volatile SingularAttribute<Productes, Categories> categories;
    public static volatile SingularAttribute<Productes, String> nom;

}