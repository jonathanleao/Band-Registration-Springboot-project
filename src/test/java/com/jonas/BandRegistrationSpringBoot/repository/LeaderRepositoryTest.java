package com.jonas.BandRegistrationSpringBoot.repository;

import com.jonas.BandRegistrationSpringBoot.domain.Leader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Test DataBase services for Leader")
class LeaderRepositoryTest {

    @Autowired
    private LeaderRepository leaderRepository;

    @Test
    @DisplayName("Save leader when successful")
    void testPersistentLeaderWheSuccessful(){
        Leader leader = createLeader();
        Leader leaderSaved = leaderRepository.save(leader);
        Assertions.assertThat(leaderSaved).isNotNull();
        Assertions.assertThat(leaderSaved.getId()).isNotNull();
        Assertions.assertThat(leaderSaved.getLeaderName()).isEqualTo(leader.getLeaderName());

    }
    @Test
    @DisplayName("update leader when successful")
    void testUpdateLeaderWheSuccessful(){
        Leader leader = createLeader();
        Leader leaderSaved = leaderRepository.save(leader);
        leaderSaved.setLeaderName("Kurt Cobain");
        leaderSaved.setSurname("KurtD");

        Assertions.assertThat(leaderSaved).isNotNull();
        Assertions.assertThat(leaderSaved.getId()).isNotNull();
        Assertions.assertThat(leaderSaved.getLeaderName()).isEqualTo(leader.getLeaderName());
    }
    @Test
    @DisplayName("Delete leader when successful")
    void testDeleteLeaderWheSuccessful(){
        Leader leader = createLeader();
        Leader leaderSaved = leaderRepository.save(leader);
        leaderRepository.delete(leaderSaved);

        Optional<Leader> byId = leaderRepository.findById(leaderSaved.getId());
        Assertions.assertThat(byId).isEmpty();
    }
    @Test
    @DisplayName("find leader by id when successful")
    void testFindByIdLeaderWheSuccessful(){
        Leader leader = createLeader();
        Leader leaderSaved = leaderRepository.save(leader);

        Optional<Leader> byId = leaderRepository.findById(leaderSaved.getId());
        Assertions.assertThat(byId).isNotNull();
        Assertions.assertThat(byId).isNotEmpty();
        Assertions.assertThat(byId).isPresent();
        Assertions.assertThat(byId.get()).isEqualTo(leaderSaved);

    }
    @Test
    @DisplayName("find leader by name when successful")
    void testFindByNameLeaderWheSuccessful(){
        Leader leader = createLeader();
        Leader leaderSaved = leaderRepository.save(leader);

        List<Leader> byLeaderNameContaining = leaderRepository.findByLeaderNameContaining(leaderSaved.getLeaderName());
        Assertions.assertThat(byLeaderNameContaining).isEmpty();
    }

    @Test
    @DisplayName("Return empty List of Leader when findByName Not found Any Leader")
    void ReturnEmptyListOfLeaderWhenFindByNameNotFoundAnyLeader(){
        Leader leader = createLeader();
        Leader leaderSaved = leaderRepository.save(leader);

        List<Leader> byLeaderNameContaining = leaderRepository.findByLeaderNameContaining("Jonathan");
        Assertions.assertThat(byLeaderNameContaining).isEmpty();
    }
     private Leader createLeader(){
        return Leader.builder()
                .leaderName("Mick Jagger")
                .surname("Lord Jagger")
                .build();
     }


}