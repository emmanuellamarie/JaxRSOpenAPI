package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.generic.UtilisateurSupportDao;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.domain.UtilisateurSupport;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/utilisateurSupport")
@Produces({"application/json"})
public class UtilisateurSupportRessource {

    UtilisateurSupportDao utilisateurSupportDao = new UtilisateurSupportDao();

    @GET
    @Path("/{id}")
    public UtilisateurSupport getUtilisateur(@PathParam("id") Integer Id){

        return utilisateurSupportDao.findOne(Id);
    }


    @GET
    @Path("/supportUser")
    public void getAllSupportUser(){

        utilisateurSupportDao.findAll();
        for (Utilisateur utilisateur: utilisateurSupportDao.findAll()){
           System.out.println( utilisateur.toString());
        }
    }
}
