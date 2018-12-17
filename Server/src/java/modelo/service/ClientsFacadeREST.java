/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Clients;
import utils.Token;

/**
 *
 * @author Angel Sandin
 */
@javax.ejb.Stateless
@Path("clients")
public class ClientsFacadeREST extends AbstractFacade<Clients> {

    @PersistenceContext(unitName = "Pocket-TradePU")
    private EntityManager em;

    public ClientsFacadeREST() {
        super(Clients.class);
        this.em = Persistence.createEntityManagerFactory("Pocket-TradePU").createEntityManager();

    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Clients entity) {
        super.create(entity);
    }
    /**
     * Modifica un nou client a la BBDD.
     * @param id enviat per url.
     * @param nom
     * @param cognoms
     * @param email
     * @param pass
     * @param token
     * @return Response amb status 200, si s'ha modificat correctament,
     * o status 404, si no s'ha pogut modificar.
     */
    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id,
                        @FormParam("nom") String nom,
                        @FormParam("cognoms") String cognoms,
                        @FormParam("email") String email,
                        @FormParam("password") String pass,
                        @FormParam("token") String token) {
        if(Token.verifyToken(token, id.toString())){
            Clients c = new Clients(id, nom, cognoms, email, pass);
            super.edit(c);
            return Response.ok().entity("Client modificat correctament").build();
        } else {
            return Response.status(404).entity("No te suficients permisos per modifica dades").build();
        }     
    }
    /**
     * Elimina un client de la BBDD
     * @param id enviat per url.
     * @param token
     * @return Response, amb status 200, si s'ha eliminat correctrament,
     * o status 401, si no s'ha pogut eliminar.
     */
    @POST
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id,
                        @FormParam("token") String token) {
        if(Token.verifyToken(token, id.toString())){
            super.remove(super.find(id));
            return Response.status(200).entity("Client eliminat").build();
        } else {
            return Response.status(401).entity("No pot eliminar el client").build();
        }
        
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Clients find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clients> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Clients> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
     * Identificar un client
     * @param email
     * @param pass
     * @return Response de un client en format JSON amb email i pass iguals que els
     * donats, per parametres. Tambe retorna un token identificatiu al Header de la peticio.
     */
    @POST
    @Path("/login/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response prueba(@FormParam("email") String email,
                            @FormParam ("password") String pass){
       try{
            Query q = getEntityManager().createNamedQuery("Clients.findByEmail");
            q.setParameter("email", email);
            Clients c = (Clients) q.getSingleResult();
            String token = null;            
            if(email.equals(c.getEmail()) && pass.equals(c.getPassword())){
                 token = Token.generateToken(c.getId().toString());
                return Response.ok().entity(c).header("token", token).build();
            } else {
                return Response.status(403).entity("Passwor incorrecte").build();
            }         
        } catch (NoResultException e){
           return Response.status(404).entity("Email incorrecte").build();
       }
    }
    /**
     * Guarda un Client a la BBDD
     * @param nom
     * @param cognoms
     * @param email
     * @param pass
     * @return Retorna un missatge de client creat correctament, i status 200.
     */
    @POST
    @Path("/add")
    public Response add(@FormParam("nom") String nom,
                            @FormParam("cognoms") String cognoms,
                            @FormParam("email") String email,
                            @FormParam("password") String pass){
        Clients c = new Clients( nom, cognoms, email, pass);
        super.create(c);
        return Response.ok().entity("Client creat correctament").build();
    }
}
