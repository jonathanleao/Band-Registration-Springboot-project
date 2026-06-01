package com.jonas.BandRegistrationSpringBoot.repository;

import com.jonas.BandRegistrationSpringBoot.domain.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BandRepository extends JpaRepository <Band, Integer>{
   List<Band> findByBandNameContaining(String bandName);
}
