package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Adrecas;
import modelo.Telefons;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-12-14T20:19:56")
@StaticMetamodel(Botigues.class)
public class Botigues_ { 

    public static volatile CollectionAttribute<Botigues, Adrecas> adrecasCollection;
    public static volatile SingularAttribute<Botigues, String> idFiscal;
    public static volatile SingularAttribute<Botigues, String> password;
    public static volatile SingularAttribute<Botigues, String> descripcio;
    public static volatile CollectionAttribute<Botigues, Telefons> telefonsCollection;
    public static volatile SingularAttribute<Botigues, String> nomComercial;
    public static volatile SingularAttribute<Botigues, Short> admin;
    public static volatile SingularAttribute<Botigues, Integer> id;
    public static volatile SingularAttribute<Botigues, String> email;

}