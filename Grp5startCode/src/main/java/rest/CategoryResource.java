/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CategoryDTO;
import facades.CategoryFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Alex Wagner
 */
@Path("category")
public class CategoryResource {

    @Context
    private UriInfo context;

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final CategoryFacade FACADE = CategoryFacade.getCategoryFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of CategoryResource
     */
    public CategoryResource() {
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategories() {
        CategoryDTO result = FACADE.getCategories();
        return GSON.toJson(result);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
