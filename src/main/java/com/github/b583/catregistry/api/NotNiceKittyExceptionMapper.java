package com.github.b583.catregistry.api;

import com.github.b583.catregistry.service.NotNiceKittyException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NotNiceKittyExceptionMapper implements ExceptionMapper<NotNiceKittyException> {

    @Override
    public Response toResponse(NotNiceKittyException e) {
        return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }
}
