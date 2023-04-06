package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.generic.SujetDao;
import fr.istic.taa.jaxrs.domain.Sujet;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.domain.UtilisateurStandard;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sujet")
@Produces({"application/json"})
public class SujetResssource {

    SujetDao sujetDao = new SujetDao();

    @GET
    @Path("{id}")
    public Sujet getSujet(@PathParam("id") Integer Id) {

        return sujetDao.findOne(Id);
    }

    @GET
    @Path("/all")
    public List<Sujet> getAllSujets() {
        return sujetDao.findAll();
    }

    @POST
    @Path("/create")
    public Response addSujet(@Parameter(description = "", required = true) Sujet sujet) {

        sujetDao.save(sujet);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/delete/all")
    public Response deleteOne(@Parameter(description = "", required = true)
                              Sujet sujet) {
        sujetDao.delete(sujet);
        return Response.ok().entity("SUCCESS").build();
    }


    @DELETE
    @Path("/delete/{id}")
    public Response deleteId(@PathParam("id") Integer Id) {

        sujetDao.deleteById(Id);
        return Response.ok().entity("SUCCESS").build();
    }

}
