package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.generic.UtilisateurDao;
import fr.istic.taa.jaxrs.domain.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/utilisateur")
@Produces({"application/json"})
public class UtilisateurResource {

    UtilisateurDao utilisateurDao = new UtilisateurDao();

    @GET
    @Path("/{id}")
    public Utilisateur getUtilisateur(@PathParam("id") Integer Id){

        return utilisateurDao.findOne(Id);
    }

    @GET
    @Path("/getAll")
    public List<Utilisateur> getUtilisateurs(){
        return utilisateurDao.findAll();
    }

    @POST
    @Path("")
    @Consumes("application/json")
    public Response addUtuilsateurs(@Parameter(description = "", required = true) Utilisateur utilisateur){

        utilisateurDao.save(utilisateur);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response DeleteUser(@PathParam("id") Integer Id){

        Utilisateur utilisateur = utilisateurDao.findOne(Id);
        utilisateurDao.delete(utilisateur);
        return Response.ok().entity("succes delele").build();
    }





}
