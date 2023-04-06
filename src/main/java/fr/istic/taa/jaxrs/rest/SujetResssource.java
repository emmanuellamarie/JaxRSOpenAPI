package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.SujetDao;
import fr.istic.taa.jaxrs.domain.Sujet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    public List<Sujet> getAllSujet() {
        return sujetDao.findAll();
    }
}
