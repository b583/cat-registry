package com.github.b583.catregistry.api;

import com.github.b583.catregistry.api.dto.CatDto;
import com.github.b583.catregistry.model.RegisteredCat;
import com.github.b583.catregistry.model.UnregisteredCat;

class CatMapper {

    private CatMapper() {
    }

    static UnregisteredCat toModel(CatDto catDto) {
        return new UnregisteredCat(catDto.getName(), catDto.getColor(), catDto.getIsNice());
    }

    static CatDto toDto(RegisteredCat registeredCat) {
        return new CatDto(registeredCat.getId(), registeredCat.getName(), registeredCat.getColor(), registeredCat.isNice());
    }

}
