package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Botigues;
import modelo.Clients;
import modelo.Propietaris;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-12-14T20:19:56")
@StaticMetamodel(Telefons.class)
public class Telefons_ { 

    public static volatile SingularAttribute<Telefons, Propietaris> idPropietari;
    public static volatile SingularAttribute<Telefons, Clients> idClient;
    public static volatile SingularAttribute<Telefons, String> telefon;
    public static volatile SingularAttribute<Telefons, Integer> id;
    public static volatile SingularAttribute<Telefons, Botigues> idBotiga;

}