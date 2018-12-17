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
import javax.ws.rs.core.Response;
import modelo.Categories;
import utils.Token;

/**
 *
 * @author angelsandin
 */
@Stateless
@Path("categories")
public class CategoriesFacadeREST extends AbstractFacade<Categories> {

    @PersistenceContext(unitName = "Pocket-TradePU")
    private EntityManager em;

    public CategoriesFacadeREST() {
        super(Categories.class);
        this.em = Persistence.createEntityManagerFactory("Pocket-TradePU").createEntityManager();
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Categories entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Categories entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Categories find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Categories> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categories> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    /**
     * Crea una categoria en la BBDD
     * @param nomCategoria
     * @param token
     * @param idBotiga
     * @return Retorna resposta de categoria creada correctament, amb codi de status 200.
     */
    @POST
    @Path("/add")
    public Response add(@FormParam("nomCategoria") String nom,
                            @FormParam("token") String token,
                            @FormParam("idBotiga") Integer id){
        if(Token.verifyToken(token, id.toString())){
            Categories c = new Categories(nom);
            super.create(c);
            return Response.ok().entity("Categoria creada correctament").build();
        } else {
            return Response.status(401).entity("No pot crear la categoria").build();
        }
    }   
    
}
