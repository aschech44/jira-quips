package com.jiraquips;

import com.atlassian.plugins.rest.common.security.AnonymousAllowed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * A resource of message.
 */
@Path("/quip")
public class QuipResource {

    /**
     * This method will be called if no extra path information
     * is used in the request.
     * @param key optional key for the message
     * @return the message from the key parameter or the default message
     */
    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getQuip(@QueryParam("key") String key)
    {
        if(key!=null)
            return Response.ok(new Quip(key, getQuipFromKey(key))).build();
        else
            return Response.ok(new Quip("default","Hello Jira Quip World")).build();
    }

    /**
     * This method will be called if the request contains an extra path
     * element.  The extra path element is extracted and passed in as the
     * key parameter.
     * @param key the key of the message
     * @return the message defined by the key
     */
    @GET
    @AnonymousAllowed
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{key}")
    public Response getQuipFromPath(@PathParam("key") String key)
    {
        return Response.ok(new Quip(key, getQuipFromKey(key))).build();
    }

    private String getQuipFromKey(String key) {
        // In reality, this data would come from a database or some component
        // within the hosting application, for demonstration purpopses I will
        // just return the key
        return key;
    }

}
