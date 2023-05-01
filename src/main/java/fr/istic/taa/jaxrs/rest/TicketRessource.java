package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.SujetDao;
import fr.istic.taa.jaxrs.dao.generic.TicketDao;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurStandardDao;
import fr.istic.taa.jaxrs.domain.Sujet;
import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.domain.UtilisateurStandard;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/ticket")
@Produces({"application/json"})
public class TicketRessource {

    TicketDao ticketDao = new TicketDao();
    SujetDao sujetDao = new SujetDao();
    UtilisateurStandardDao utilisateurStandardDao = new UtilisateurStandardDao();

    @GET
    @Path("/{id}")
    public Response getTicket(@PathParam("id") Integer Id) {
        Response re = Response.ok(ticketDao.findOne(Id))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .build();
        return re;
    }


    @GET
    @Path("/all")
    public Response getAllTicket() {

        //return ticketDao.findAll();
        Response re = Response.ok(ticketDao.findAll())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .build();
        return re;

    }

    @POST()
    @Path("/add")
    public Response addTicket(@Parameter(description = "", required = true) Ticket ticket) {

        // System.out.println(sujet.toString()+utilisateurStandard.toString());

        if ((sujetDao.findOne(ticket.getSujet().getId())) != null
                && (utilisateurStandardDao.findOne(ticket.getUtilisateurStandard().getId())) != null
        ) {
            ticketDao.save(ticket);
            return Response.ok().entity("SUCCESS").build();
        } else {
            return Response.ok().entity("FAIL").build();
        }


    }

    @DELETE
    @Path("/delete/all")
    public Response deleteOne(@Parameter(description = "", required = true)
                              Ticket ticket) {
        ticketDao.delete(ticket);
        return Response.ok().entity("SUCCESS").build();
    }


    @DELETE
    @Path("/delete/{id}")
    public Response deleteId(@PathParam("id") Integer Id) {

        ticketDao.deleteById(Id);
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Path("/update")
    public Response update(@Parameter(description = "", required = true)
                           Ticket ticket){
        if(ticketDao.findOne(ticket.getId()) != null){
            ticketDao.update(ticket);
            return Response.ok().entity("SUCCESS").build();
        }
        else{
            return Response.ok().entity("FAIL").build();
        }

    }
}