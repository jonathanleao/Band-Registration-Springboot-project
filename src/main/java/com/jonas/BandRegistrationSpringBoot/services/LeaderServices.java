package com.jonas.BandRegistrationSpringBoot.services;

import com.jonas.BandRegistrationSpringBoot.DTO.leaderRequests.LeaderPostRequest;
import com.jonas.BandRegistrationSpringBoot.DTO.leaderRequests.LeaderPutRequest;
import com.jonas.BandRegistrationSpringBoot.domain.Leader;
import com.jonas.BandRegistrationSpringBoot.exceptions.BadRequestException;
import com.jonas.BandRegistrationSpringBoot.exceptions.NotFoundException;
import com.jonas.BandRegistrationSpringBoot.mapper.LeaderMapper;
import com.jonas.BandRegistrationSpringBoot.repository.LeaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderServices {

    private final LeaderRepository leaderRepository;
    private final LeaderMapper leaderMapper;

    public Leader findById(Integer id) {
        requireValidId(id);
        return leaderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id not found"));
    }

    public List<Leader> findByName(String leaderName) {
        return leaderRepository.findByLeaderNameContaining(leaderName);
    }

    @Transactional
    public Leader save(LeaderPostRequest leaderPostRequest) {
        Leader leader = leaderMapper.toLeaderPost(leaderPostRequest);
        return leaderRepository.save(leader);
    }

    @Transactional
    public Leader update(LeaderPutRequest leaderPutRequest) {
        requireValidId(leaderPutRequest.getId());
        Leader leader = findById(leaderPutRequest.getId());
        leaderMapper.toLeaderPut(leaderPutRequest, leader);
        return leaderRepository.save(leader);
    }

    public void delete(Integer id) {
        requireValidId(id);
        leaderRepository.delete(findById(id));
    }

    private static void requireValidId(Integer id) {
        if (id == null || id <= 0) {
            throw new BadRequestException("Invalid Id");
        }
    }
}