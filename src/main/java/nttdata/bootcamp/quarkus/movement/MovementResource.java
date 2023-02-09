package nttdata.bootcamp.quarkus.movement;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nttdata.bootcamp.quarkus.movement.entity.MovementEntity;
import nttdata.bootcamp.quarkus.movement.service.MovementService;
import org.jboss.logging.Logger;

import java.util.List;

@Path("/api/movements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovementResource {
    private static final Logger LOGGER = Logger.getLogger(MovementResource.class.getName());
    @Inject
    private MovementService service;
    @GET
    public List<MovementEntity> getClients() {
        return service.listAll();
    }
    @GET
    @Path("{idMovement}")
    public MovementEntity viewClientDetails(@PathParam("idMovement") Long idMovement) {
        MovementEntity entity = service.findById(idMovement);
        if (entity == null) {
            throw new WebApplicationException("Movement with id of " + idMovement + " does not exist.", 404);
        }
        return entity;
    }
    @POST
    @Transactional
    public Response create(MovementEntity movement) {

        service.save(movement);
        return Response.ok(movement).status(201).build();
    }
    @DELETE
    @Path("{idMovement}")
    @Transactional
    public Response delete(@PathParam("idMovement") Long idMovement) {
        MovementEntity entity = service.findById(idMovement);
        if (entity == null) {
            throw new WebApplicationException("Movement with id of " + idMovement + " does not exist.", 404);
        }
        service.delete(entity.getIdMovement());
        return Response.status(204).build();
    }

    @PUT
    @Path("{idMovent}")
    @Transactional
    public MovementEntity updateMovement(@PathParam("idMovent") Long idMovent, MovementEntity movent) {

        MovementEntity entity = service.findById(idMovent);
        if (entity == null) {
            throw new WebApplicationException("Movent with id of " + idMovent + " does not exist.", 404);
        }

        entity.setIdTypeMovement(movent.getIdTypeMovement());
        entity.setDescriptionMovement(movent.getDescriptionMovement());
        entity.setDateMovement(movent.getDateMovement());
        entity.setTotalMovement(movent.getTotalMovement());

        service.save(entity);

        return entity;
    }
}