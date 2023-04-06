package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.CommentaireDao;
import fr.istic.taa.jaxrs.dao.generic.TicketDao;
import fr.istic.taa.jaxrs.dao.generic.UtilisateurDao;
import fr.istic.taa.jaxrs.domain.Commentaire;
import fr.istic.taa.jaxrs.domain.Sujet;
import fr.istic.taa.jaxrs.domain.Ticket;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/commentaire")
@Produces({"application/json"})
public class CommentaireRessource {

    CommentaireDao commentaireDao = new CommentaireDao();
    TicketDao ticketDao = new TicketDao();
    UtilisateurDao utilisateurDao = new UtilisateurDao();

    @GET
    @Path("/{id}")
    public Commentaire getCommentaire(@PathParam("id") Integer Id){

        return commentaireDao.findOne(Id);
    }

    @GET
    @Path("/all")
    public List<Commentaire> getAllTicket(){

        return commentaireDao.findAll();

    }

    @POST
    @Path("/add")
    public Response createCommentaire(@Parameter(description = "", required = true) Commentaire commentaire){

        if(ticketDao.findOne(commentaire.getTicket().getId())!= null &&
                utilisateurDao.findOne(commentaire.getUtilisateur().getId())!=null){
            commentaireDao.save(commentaire);
            return Response.ok().entity("SUCCESS").build();

        }else{
            return Response.ok().entity("FAIL").build();
        }
    }

    @POST
    @Path("/update")
    public Response update(@Parameter(description = "", required = true)
                           Commentaire commentaire){
        if(commentaireDao.findOne(commentaire.getId()) != null){
            commentaireDao.update(commentaire);
            return Response.ok().entity("SUCCESS").build();
        }
        else{
            return Response.ok().entity("FAIL").build();
        }

    }


}
