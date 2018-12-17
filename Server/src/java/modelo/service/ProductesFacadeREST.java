/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import modelo.Categories;
import modelo.Productes;
import modelo.ProductesPK;
import utils.Token;

/**
 *
 * @author angelsandin
 */
@Stateless
@Path("productes")
public class ProductesFacadeREST extends AbstractFacade<Productes> {

    @PersistenceContext(unitName = "Pocket-TradePU")
    private EntityManager em;

    private ProductesPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;id=idValue;botiguesId=botiguesIdValue;categoriesId=categoriesIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        modelo.ProductesPK key = new modelo.ProductesPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> id = map.get("id");
        if (id != null && !id.isEmpty()) {
            key.setId(new java.lang.Integer(id.get(0)));
        }
        java.util.List<String> botiguesId = map.get("botiguesId");
        if (botiguesId != null && !botiguesId.isEmpty()) {
            key.setBotiguesId(new java.lang.Integer(botiguesId.get(0)));
        }
        java.util.List<String> categoriesId = map.get("categoriesId");
        if (categoriesId != null && !categoriesId.isEmpty()) {
            key.setCategoriesId(new java.lang.Integer(categoriesId.get(0)));
        }
        return key;
    }

    public ProductesFacadeREST() {
        super(Productes.class);
        this.em = Persistence.createEntityManagerFactory("Pocket-TradePU").createEntityManager();

    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Productes entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Productes entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        modelo.ProductesPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Productes find(@PathParam("id") PathSegment id) {
        modelo.ProductesPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Productes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Productes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    /**
     * Crea un producte en la BBDD
     * @param nom
     * @param descripcio
     * @param preu
     * @param iva
     * @param pvp
     * @param foto
     * @param idCategoria
     * @param token
     * @param idBotiga
     * @return Retorna resposta de producte creat correctament, amb codi de status 200.
     */
    @POST
    @Path("/add")
    public Response add(@FormParam("nom") String nom,
                            @FormParam("descripcio") String descripcio,
                            @FormParam("preu") Float preu,
                            @FormParam("iva") Float iva,
                            @FormParam("pvp") Float pvp,
                            @FormParam("foto") String foto,
                            @FormParam("idCategoria") Integer idCategoria,
                            @FormParam("token") String token,
                            @FormParam("idBotiga") Integer idBotiga){
        if(Token.verifyToken(token, idBotiga.toString())){
            ProductesPK productesPK = new ProductesPK(idBotiga, idCategoria);
            Productes p = new Productes(productesPK, nom, preu, iva, pvp);
            p.setDescripcio(descripcio);
            p.setFoto(foto);
            super.create(p);
            return Response.ok().entity("Producte creat correctament").build();
        } else {
            return Response.status(401).entity("No pot crear el producte").build();
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
