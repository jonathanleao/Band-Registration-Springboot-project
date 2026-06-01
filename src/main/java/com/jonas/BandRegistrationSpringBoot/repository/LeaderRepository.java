package com.jonas.BandRegistrationSpringBoot.repository;

import com.jonas.BandRegistrationSpringBoot.domain.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaderRepository extends JpaRepository<Leader, Integer>{
    List<Leader> findByLeaderNameContaining(String leaderName);
}
