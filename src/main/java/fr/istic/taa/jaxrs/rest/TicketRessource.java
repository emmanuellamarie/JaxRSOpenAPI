package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.TicketDao;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurStandardDao;
import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import fr.istic.taa.jaxrs.domain.UtilisateurStandard;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
}
