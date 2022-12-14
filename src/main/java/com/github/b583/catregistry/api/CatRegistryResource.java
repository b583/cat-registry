package com.github.b583.catregistry.api;

import com.github.b583.catregistry.api.dto.CatDto;
import com.github.b583.catregistry.service.CatRegistryService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.github.b583.catregistry.api.CatMapper.toDto;
import static com.github.b583.catregistry.api.CatMapper.toModel;

@Singleton
@Path("/cat")
@Produces(MediaType.APPLICATION_JSON)
public class CatRegistryResource {

    private final CatRegistryService catRegistryService;

    @Inject
    CatRegistryResource(CatRegistryService catRegistryService) {
        this.catRegistryService = catRegistryService;
    }

    @UnitOfWork
    @POST
    public CatDto registerACat(CatDto catDto) {
        final var unregisteredCat = toModel(catDto);
        return toDto(catRegistryService.registerCat(unregisteredCat));
    }

}
