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
    public Response getSujet(@PathParam("id") Integer Id) {

        Response re = Response.ok(sujetDao.findOne(Id))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .build();
        return re;
    }

    @GET
    @Path("/all")
    public Response getAllSujets() {

        Response re = Response.ok(sujetDao.findAll())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .build();
        return re;
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

    @POST
    @Path("/update")
    public Response update(@Parameter(description = "", required = true)
                               Sujet sujet){
        if(sujetDao.findOne(sujet.getId()) != null){
            sujetDao.update(sujet);
            return Response.ok().entity("SUCCESS").build();
        }
        else{
            return Response.ok().entity("FAIL").build();
        }

    }

}
