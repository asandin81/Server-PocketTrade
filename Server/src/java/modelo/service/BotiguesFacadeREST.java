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
import modelo.Botigues;
import utils.Token;

/**
 *
 * @author Angel Sandin
 */
@javax.ejb.Stateless
@Path("botigues")
public class BotiguesFacadeREST extends AbstractFacade<Botigues> {

    @PersistenceContext(unitName = "Pocket-TradePU")
    private EntityManager em;

    public BotiguesFacadeREST() {
        super(Botigues.class);
        this.em = Persistence.createEntityManagerFactory("Pocket-TradePU").createEntityManager();

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Override
    public void create(Botigues entity) {
        super.create(entity);
    }
    /**
     * Modifica una Botiga de la BBDD
     * @param id enviat per url
     * @param idFiscal
     * @param nomComercial
     * @param email
     * @param descripcio
     * @param admin
     * @param pass
     * @param token
     * @return Response amb status 200, si s'ha modificat correctament,
     * o status 404, si no s'ha pogut modificar.
     */
    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id,
                        @FormParam("idFiscal") String idFiscal,
                        @FormParam("nomComercial") String nomComercial,
                        @FormParam("email") String email,
                        @FormParam("descripcio") String descripcio,
                        @FormParam("admin") String admin,
                        @FormParam("password") String pass,
                        @FormParam("token") String token) {
        if(Token.verifyToken(token, id.toString())){
            Botigues botiga = new Botigues(id, idFiscal, nomComercial, email, descripcio, Short.valueOf(admin), pass);
            super.edit(botiga);
            return Response.ok().entity("Botiga modificada correctament").build();
        } else {
            return Response.status(404).entity("No te suficients permisos per modifica dades").build();
        }     
    }
    /**
     * Elimina una Botiga de la BBDD
     * @param id enviat per url
     * @param token
     * @return Response, amb stuatus 200, si sha eliminat correctament,
     * o status 401, si no s'ha pogut eliminar.
     */
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id,
                        @FormParam("token") String token) {
        if(Token.verifyToken(token, id.toString())){
            super.remove(super.find(id));
            return Response.status(200).entity("Botiga eliminada").build();
        } else {
            return Response.status(401).entity("No pot eliminar la botiga").build();
        }
        
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Botigues find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Botigues> findAll() {
        return super.findAll();
    }


    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Botigues> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
     * Identifica a una Botiga
     * @param email
     * @param pass
     * @return un JSON, en el body amb la botiga amb email y pass donats per parametres.
     * Tambe retorna un token identificatiu, al header de la resposta.
     */
    @POST
    @Path("/login/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response prueba(@FormParam("email") String email,
                            @FormParam ("password") String pass){
       try{
            Query q = getEntityManager().createNamedQuery("Botigues.findByEmail");
            q.setParameter("email", email);
            Botigues botiga = (Botigues) q.getSingleResult();
            String token = null;            
            if(email.equals(botiga.getEmail()) && pass.equals(botiga.getPassword())){
                 token = Token.generateToken(botiga.getId().toString());
             
                return Response.ok().entity(botiga).header("token", token).build();
            } else {
                return Response.status(403).entity("Passwor incorrecte").build();
            }         
        } catch (NoResultException e){
           return Response.status(404).entity("Email incorrecte").build();
       }
    }
    /**
     * Guarda una nova Botiga a la BBDD
     * @param idFiscal
     * @param nomComercial
     * @param email
     * @param admin
     * @param descripcio
     * @param pass
     * @return Retorna resporsta de botiga creada correctament, amb codi de status 200.
     */
    @POST
    @Path("/add")
    public Response add(@FormParam("idFiscal") String idFiscal,
                            @FormParam("nomComercial") String nomComercial,
                            @FormParam("email") String email,
                            @FormParam("admin") String admin,
                            @FormParam("descripcio") String descripcio,
                            @FormParam("password") String pass){
        Botigues b = new Botigues(idFiscal, nomComercial, email, descripcio, Short.valueOf(admin), pass);
        super.create(b);
        return Response.ok().entity("Botiga creada correctament").build();
    }       
    
    
}
