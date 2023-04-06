package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.UtilisateurStandardDao;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurSupportDao;
import fr.istic.taa.jaxrs.domain.Sujet;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.domain.UtilisateurStandard;
import fr.istic.taa.jaxrs.domain.UtilisateurSupport;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/utilisateurStandard")
@Produces({"application/json"})
public class UtilsateurStandardRessource {


    UtilisateurStandardDao utilisateurStandardDao = new UtilisateurStandardDao();

    @GET
    @Path("/{id}")
    public UtilisateurStandard getUtilisateur(@PathParam("id") Integer Id){

        return utilisateurStandardDao.findOne(Id);
    }


    @GET
    @Path("/all")
    public List<UtilisateurStandard> getAllSupportUser(){

        return utilisateurStandardDao.findAll();

    }

    @POST
    @Path("/add")
    public Response addUtilisateurStandard(@Parameter(description = "", required = true)
                                               UtilisateurStandard utilisateurStandard){

        utilisateurStandardDao.save(utilisateurStandard);
        return Response.ok().entity("SUCCESS").build();

    }
    @DELETE
    @Path("/delete/all")
    public Response deleteOne(@Parameter(description = "", required = true)
                              UtilisateurStandard utilisateurStandard){
        utilisateurStandardDao.delete(utilisateurStandard);
        return Response.ok().entity("SUCCESS").build();
    }


    @DELETE
    @Path("/delete/{id}")
    public Response deleteId(@PathParam("id") Integer Id){

        utilisateurStandardDao.deleteById(Id);
        return Response.ok().entity("SUCCESS").build();
    }


}
