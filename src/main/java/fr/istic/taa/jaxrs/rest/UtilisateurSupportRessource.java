package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.generic.UtilisateurSupportDao;
import fr.istic.taa.jaxrs.domain.Sujet;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.domain.UtilisateurStandard;
import fr.istic.taa.jaxrs.domain.UtilisateurSupport;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/utilisateurSupport")
@Produces({"application/json"})
public class UtilisateurSupportRessource {

    UtilisateurSupportDao utilisateurSupportDao = new UtilisateurSupportDao();

    @GET
    @Path("/{id}")
    public UtilisateurSupport getUtilisateur(@PathParam("id") Integer Id) {

        return utilisateurSupportDao.findOne(Id);
    }


    @GET
    @Path("/supportUser")
    public void getAllSupportUser() {

        utilisateurSupportDao.findAll();
        for (Utilisateur utilisateur : utilisateurSupportDao.findAll()) {
            System.out.println(utilisateur.toString());
        }
    }

    @DELETE
    @Path("/delete/all")
    public Response deleteOne(@Parameter(description = "", required = true)
                              UtilisateurSupport utilisateurSupport) {
        utilisateurSupportDao.delete(utilisateurSupport);
        return Response.ok().entity("SUCCESS").build();
    }


    @DELETE
    @Path("/delete/{id}")
    public Response deleteId(@PathParam("id") Integer Id) {

        utilisateurSupportDao.deleteById(Id);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update")
    public Response update(@Parameter(description = "", required = true)
                           UtilisateurSupport utilisateurSupport){
        if(utilisateurSupportDao.findOne(utilisateurSupport.getId()) != null){
            utilisateurSupportDao.update(utilisateurSupport);
            return Response.ok().entity("SUCCESS").build();
        }
        else{
            return Response.ok().entity("FAIL").build();
        }

    }

}
