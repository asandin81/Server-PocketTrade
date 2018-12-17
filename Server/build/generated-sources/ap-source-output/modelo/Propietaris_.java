package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Adrecas;
import modelo.Telefons;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-12-14T20:19:56")
@StaticMetamodel(Propietaris.class)
public class Propietaris_ { 

    public static volatile CollectionAttribute<Propietaris, Adrecas> adrecasCollection;
    public static volatile SingularAttribute<Propietaris, String> cognoms;
    public static volatile SingularAttribute<Propietaris, String> telefon;
    public static volatile CollectionAttribute<Propietaris, Telefons> telefonsCollection;
    public static volatile SingularAttribute<Propietaris, String> adreca;
    public static volatile SingularAttribute<Propietaris, String> nif;
    public static volatile SingularAttribute<Propietaris, Integer> id;
    public static volatile SingularAttribute<Propietaris, String> nom;
    public static volatile SingularAttribute<Propietaris, String> email;

}