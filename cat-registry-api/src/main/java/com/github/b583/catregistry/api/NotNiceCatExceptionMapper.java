package com.github.b583.catregistry.api;

import com.github.b583.catregistry.service.NotNiceCatException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NotNiceCatExceptionMapper implements ExceptionMapper<NotNiceCatException> {

    @Override
    public Response toResponse(NotNiceCatException e) {
        return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }
}
