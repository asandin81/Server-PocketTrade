package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Adrecas;
import modelo.Telefons;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-12-14T20:19:56")
@StaticMetamodel(Clients.class)
public class Clients_ { 

    public static volatile CollectionAttribute<Clients, Adrecas> adrecasCollection;
    public static volatile SingularAttribute<Clients, String> password;
    public static volatile SingularAttribute<Clients, String> cognoms;
    public static volatile CollectionAttribute<Clients, Telefons> telefonsCollection;
    public static volatile SingularAttribute<Clients, Integer> id;
    public static volatile SingularAttribute<Clients, String> nom;
    public static volatile SingularAttribute<Clients, String> email;

}