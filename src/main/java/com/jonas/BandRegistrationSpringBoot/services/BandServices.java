package com.jonas.BandRegistrationSpringBoot.services;

import com.jonas.BandRegistrationSpringBoot.DTO.bandRequests.BandPostRequest;
import com.jonas.BandRegistrationSpringBoot.DTO.bandRequests.BandPutRequest;
import com.jonas.BandRegistrationSpringBoot.domain.Band;
import com.jonas.BandRegistrationSpringBoot.domain.Leader;
import com.jonas.BandRegistrationSpringBoot.exceptions.BadRequestException;
import com.jonas.BandRegistrationSpringBoot.exceptions.NotFoundException;
import com.jonas.BandRegistrationSpringBoot.mapper.BandMapper;
import com.jonas.BandRegistrationSpringBoot.repository.BandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BandServices {

    private final BandRepository bandRepository;
    private final LeaderServices leaderServices;
    private final BandMapper bandMapper;

    public Band findById(Integer id) {
        requireValidId(id);
        return bandRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id not found"));
    }

    public List<Band> findByName(String bandName) {
        return bandRepository.findByBandNameContaining(bandName);
    }

    @Transactional
    public Band save(BandPostRequest bandPostRequest) {
        Leader leader = leaderServices.findById(bandPostRequest.getLeaderId());
        Band band = bandMapper.toBandPost(bandPostRequest);
        band.setLeader(leader);

        return bandRepository.save(band);
    }

    @Transactional
    public Band update(BandPutRequest bandPutRequest) {
        requireValidId(bandPutRequest.getId());
        Band band = findById(bandPutRequest.getId());
        Leader leader = leaderServices.findById(bandPutRequest.getLeaderId());
        bandMapper.toBandPut(bandPutRequest, band);
        band.setLeader(leader);
        return bandRepository.save(band);
    }

    public void delete(Integer id) {
        requireValidId(id);
        bandRepository.delete(findById(id));
    }

    private static void requireValidId(Integer id) {
        if (id == null || id <= 0) {
            throw new BadRequestException("Invalid Id");
        }
    }
}
