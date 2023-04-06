package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.TicketDao;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurStandardDao;
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

    @GET
    @Path("/{id}")
    public Ticket getTicket(@PathParam("id") Integer Id){

        return ticketDao.findOne(Id);
    }
    @GET
    @Path("/all")
    public List<Ticket> getAllTicket(){
        return ticketDao.findAll();
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response addTicket(@Parameter(description = "", required = true) Ticket ticket){
        ticketDao.save(ticket);
        return Response.ok().entity("SUCCESS").build();
    }
}
