package com.github.b583.catregistry.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cat")
@Produces(MediaType.APPLICATION_JSON)
public class CatRegistryResource {

    @POST
    public CatDto registerACat(CatDto catDto) {
        // TODO pass to a service
        return catDto;
    }

}
