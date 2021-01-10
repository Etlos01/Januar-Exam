/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.EventDTO;
import dtos.UserDTO;
import entities.User;
import facades.EventFacade;
import facades.UserFacade;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Nyxis
 */
@Path("event")
public class EventResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EventFacade FACADE = EventFacade.getEventFacade(EMF);

    @Context
    private UriInfo context;
    @Context
    SecurityContext securityContext;

    /**
     * Creates a new instance of EventResource
     */
    public EventResource() {
    }

    @GET
    @Path("/{calendarId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEventsByCalendar(@PathParam("calendarId") int calendarId) {
        EventDTO e = FACADE.getEventsByCalendar(calendarId);
        return GSON.toJson(e);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of EventResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @RolesAllowed("user")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String addEvent(String event) {
        EventDTO e = GSON.fromJson(event, EventDTO.class);
        String thisUser = securityContext.getUserPrincipal().getName();
        EventDTO newEvent = FACADE.addEvent(e, thisUser);

        return GSON.toJson(newEvent);
    }
    
    
    @GET
    @RolesAllowed("user")
    @Path("/getallevents")
    @Produces({MediaType.APPLICATION_JSON})
    public String getEvents(){
        String thisUser = securityContext.getUserPrincipal().getName();
        return GSON.toJson(FACADE.getEvents(thisUser));
    }
    

}
