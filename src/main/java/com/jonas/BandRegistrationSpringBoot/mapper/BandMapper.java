package com.jonas.BandRegistrationSpringBoot.mapper;

import com.jonas.BandRegistrationSpringBoot.DTO.bandRequests.BandPostRequest;
import com.jonas.BandRegistrationSpringBoot.DTO.bandRequests.BandPutRequest;
import com.jonas.BandRegistrationSpringBoot.domain.Band;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BandMapper {

    @Mapping(target = "leader", ignore = true)
    Band toBandPost(BandPostRequest bandPostRequest);

    @Mapping(target = "leader", ignore = true)
    void toBandPut(BandPutRequest bandPutRequest, @MappingTarget Band band);
}
