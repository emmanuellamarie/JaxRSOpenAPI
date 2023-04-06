package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.UtilisateurStandardDao;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurSupportDao;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.domain.UtilisateurStandard;
import fr.istic.taa.jaxrs.domain.UtilisateurSupport;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
    public void getAllSupportUser(){
        utilisateurStandardDao.findAll();
        for (Utilisateur utilisateur: utilisateurStandardDao.findAll()){
            System.out.println( utilisateur.toString());
        }
    }
}
