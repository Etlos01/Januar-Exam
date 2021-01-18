/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ActivityDTO;
import facades.ActivityFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;
import javax.ws.rs.core.SecurityContext;


/**
 * REST Web Service
 *
 * @author Nyxis
 */
@Path("activity")
public class ActivityResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final ActivityFacade FACADE = ActivityFacade.getActivityFacade(EMF);

    @Context
    private UriInfo context;
    @Context
    SecurityContext securityContext;

    /**
     * Creates a new instance of ActivityResource
     */
    public ActivityResource() {
    }

    /**
     * Retrieves representation of an instance of rest.ActivityResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @POST
    @RolesAllowed("user")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String addActivity(String activity) {
        ActivityDTO a = GSON.fromJson(activity, ActivityDTO.class);
        String thisUser = securityContext.getUserPrincipal().getName();
        ActivityDTO newActivityDTO = FACADE.addActivity(a, thisUser);

        return GSON.toJson(newActivityDTO);
    }
    

    /**
     * PUT method for updating or creating an instance of ActivityResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
