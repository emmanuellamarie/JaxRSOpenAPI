package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.generic.UtilisateurDao;
import fr.istic.taa.jaxrs.domain.Utilisateur;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import net.bytebuddy.implementation.bind.annotation.Origin;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/utilisateur")
@Produces({ "application/json" })
public class UtilisateurResource {

    UtilisateurDao utilisateurDao = new UtilisateurDao();

    @GET
    @Path("/{id}")
    public Response getUtilisateur(@PathParam("id") Integer Id) {
        Response re = Response.ok(utilisateurDao.findOne(Id))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .build();
        return re;
    }

    @GET
    @Path("/getAll")
    public Response getUtilisateurs() {

        Response re = Response.ok(utilisateurDao.findAll())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET")
                .build();

        return re;
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    public Response addUtuilsateurs(@Parameter(description = "", required = true) Utilisateur utilisateur) {

        utilisateurDao.save(utilisateur);
        return Response.ok(utilisateur)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, OPTIONS, HEAD")
                .build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response DeleteUser(@PathParam("id") Integer Id) {

        Utilisateur utilisateur = utilisateurDao.findOne(Id);
        utilisateurDao.delete(utilisateur);
        return Response.ok()
                .entity("succes delele")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "DELETE")
                .build();
    }

    @DELETE
    @Path("/delete/all")
    public Response deleteOne(@Parameter(description = "", required = true) Utilisateur utilisateur) {
        utilisateurDao.delete(utilisateur);
        return Response.ok()
                .entity("SUCCESS")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "DELETE")
                .build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteId(@PathParam("id") Integer Id) {

        utilisateurDao.deleteById(Id);
        return Response.ok()
                .entity("SUCCESS")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "DELETE")
                .build();
    }

    @POST
    @Path("/update")
    public Response update(@Parameter(description = "", required = true) Utilisateur utilisateur) {
        if (utilisateurDao.findOne(utilisateur.getId()) != null) {
            utilisateurDao.update(utilisateur);
            return Response.ok()
                    .entity("SUCCESS")
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "POST")
                    .build();
        } else {
            return Response.ok()
                    .entity("FAIL")
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "POST")
                    .build();
        }

    }

}
