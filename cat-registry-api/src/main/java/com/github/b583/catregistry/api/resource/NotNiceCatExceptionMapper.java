package com.github.b583.catregistry.api.resource;

import com.github.b583.catregistry.api.WebResource;
import com.github.b583.catregistry.service.NotNiceCatException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NotNiceCatExceptionMapper implements ExceptionMapper<NotNiceCatException>, WebResource {

    @Override
    public Response toResponse(NotNiceCatException e) {
        return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }
}
