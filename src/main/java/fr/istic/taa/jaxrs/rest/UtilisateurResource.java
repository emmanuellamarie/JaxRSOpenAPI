package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.generic.UtilisateurDao;
import fr.istic.taa.jaxrs.domain.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.Sujet;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.domain.UtilisateurStandard;
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
    @Path("/create")
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

    @DELETE
    @Path("/delete/all")
    public Response deleteOne(@Parameter(description = "", required = true)
                              Utilisateur utilisateur){
        utilisateurDao.delete(utilisateur);
        return Response.ok().entity("SUCCESS").build();
    }


    @DELETE
    @Path("/delete/{id}")
    public Response deleteId(@PathParam("id") Integer Id) {

        utilisateurDao.deleteById(Id);
        return Response.ok().entity("SUCCESS").build();
    }


    @POST
    @Path("/update")
    public Response update(@Parameter(description = "", required = true)
                           Utilisateur utilisateur){
        if(utilisateurDao.findOne(utilisateur.getId()) != null){
            utilisateurDao.update(utilisateur);
            return Response.ok().entity("SUCCESS").build();
        }
        else{
            return Response.ok().entity("FAIL").build();
        }

    }






}
