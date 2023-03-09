package com.sh;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class GreetingResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reference> hello() {
        return List.of(Reference.of("Hello", "from"), Reference.of("RESTEasy", "to"));
    }
}