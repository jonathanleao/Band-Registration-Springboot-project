package com.jonas.BandRegistrationSpringBoot.mapper;

import com.jonas.BandRegistrationSpringBoot.DTO.leaderRequests.LeaderPostRequest;
import com.jonas.BandRegistrationSpringBoot.DTO.leaderRequests.LeaderPutRequest;
import com.jonas.BandRegistrationSpringBoot.domain.Leader;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LeaderMapper {

    Leader toLeaderPost(LeaderPostRequest leaderPostRequest);

    void toLeaderPut(LeaderPutRequest leaderPutRequest, @MappingTarget Leader leader);
}
