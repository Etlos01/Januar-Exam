/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HolidayDTO;
import facades.DataFetcherFacade;
import facades.HolidayFacade;
import java.io.IOException;
import java.util.Collection;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author Alex Wagner
 */
@Path("holidays")
public class HolidayResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final HolidayFacade FACADE = HolidayFacade.getHolidayFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    public HolidayResource() {
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHolidays() {
        HolidayDTO result = FACADE.getHolidays();
        return GSON.toJson(result);
    }
}
