package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Botigues;
import modelo.Clients;
import modelo.Propietaris;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-12-14T20:19:56")
@StaticMetamodel(Adrecas.class)
public class Adrecas_ { 

    public static volatile SingularAttribute<Adrecas, String> poblacio;
    public static volatile SingularAttribute<Adrecas, String> comarca;
    public static volatile SingularAttribute<Adrecas, Propietaris> idPropietari;
    public static volatile SingularAttribute<Adrecas, String> numero;
    public static volatile SingularAttribute<Adrecas, Clients> idClient;
    public static volatile SingularAttribute<Adrecas, String> carrer;
    public static volatile SingularAttribute<Adrecas, Integer> id;
    public static volatile SingularAttribute<Adrecas, Botigues> idBotiga;
    public static volatile SingularAttribute<Adrecas, String> cp;
    public static volatile SingularAttribute<Adrecas, String> pais;

}