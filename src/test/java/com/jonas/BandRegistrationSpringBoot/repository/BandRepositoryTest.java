package com.jonas.BandRegistrationSpringBoot.repository;

import com.jonas.BandRegistrationSpringBoot.domain.Band;
import com.jonas.BandRegistrationSpringBoot.domain.Leader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@DisplayName("Test Band Database methods")
class BandRepositoryTest {
    @Autowired
    private BandRepository bandRepository;
    @Autowired
    private LeaderRepository leaderRepository;

    @Test
    @DisplayName("Save band when save Method is successful")
    void testPersistentBandWhenSuccessful() {
        Leader saveLeader = leaderRepository.save(createLeader());
        Band band = createBand(saveLeader);
        Band bandSaved = bandRepository.save(band);

        Assertions.assertThat(bandSaved).isNotNull();
        Assertions.assertThat(bandSaved.getId()).isNotNull();
        Assertions.assertThat(bandSaved.getLeader().getId()).isEqualTo(saveLeader.getId());
    }

    @Test
    @DisplayName("Update band when save Method is successful")
    void testUpdateBandWhenSuccessful() {
        Leader saveLeader = leaderRepository.save(createLeader());
        Band band = createBand(saveLeader);
        Band bandSaved = bandRepository.save(band);
        bandSaved.setBandName("White Stripes");
        bandSaved.setNumMembers(2);
        Band bandUpdate = bandRepository.save(bandSaved);

        Assertions.assertThat(bandUpdate.getId()).isNotNull();
        Assertions.assertThat(bandUpdate.getLeader().getId()).isEqualTo(saveLeader.getId());
        Assertions.assertThat(bandUpdate.getLeader().getLeaderName()).isEqualTo(saveLeader.getLeaderName());
        Assertions.assertThat(bandUpdate.getBandName()).isEqualTo("White Stripes");
        Assertions.assertThat(bandUpdate.getNumMembers()).isEqualTo(2);
        Assertions.assertThat(bandUpdate.getLeader().getId()).isEqualTo(saveLeader.getId());
    }

    @Test
    @DisplayName("Delete band when save Method is successful")
    void testDeleteBandWhenSuccessful() {
        Leader saveLeader = leaderRepository.save(createLeader());
        Band band = createBand(saveLeader);
        Band bandSaved = bandRepository.save(band);
        bandRepository.delete(bandSaved);

        Optional<Band> byId = bandRepository.findById(bandSaved.getId());

        Assertions.assertThat(byId).isEmpty();
    }

    @Test
    @DisplayName("Find band By id when save Method is successful")
    void testFindBandByIdWhenSuccessful() {
        Leader saveLeader = leaderRepository.save(createLeader());
        Band band = createBand(saveLeader);
        Band bandSaved = bandRepository.save(band);

        Optional<Band> byId = bandRepository.findById(bandSaved.getId());

        Assertions.assertThat(byId).isPresent();
        Assertions.assertThat(byId.get()).isEqualTo(bandSaved);
        Assertions.assertThat(byId).contains(bandSaved);
    }

    @Test
    @DisplayName("Return List of band when 'find By name' is successful")
    void testFindBandByNameWhenSuccessful() {
        Leader saveLeader = leaderRepository.save(createLeader());
        Band band = createBand(saveLeader);
        Band bandSaved = bandRepository.save(band);

        List<Band>byBandNameContaining  = bandRepository.findByBandNameContaining(bandSaved.getBandName());
        Assertions.assertThat(byBandNameContaining).isNotEmpty();
        Assertions.assertThat(byBandNameContaining).contains(bandSaved);
    }

    @Test
    @DisplayName("Return empty List of band when 'find By name' is failure")
    void testReturnEmptyListOfBandWhenFindByNameFailure() {
        Leader saveLeader = leaderRepository.save(createLeader());
        Band band = createBand(saveLeader);
        Band bandSaved = bandRepository.save(band);

        List<Band>byBandNameContaining  = bandRepository.findByBandNameContaining("Kurt");
        Assertions.assertThat(byBandNameContaining).isEmpty();
        Assertions.assertThat(byBandNameContaining).doesNotContain(bandSaved);
    }


    private static Band createBand(Leader leader) {
        return Band.builder()
                .bandName("Metallica")
                .numMembers(5)
                .leader(leader).build();
    }

    private static Leader createLeader() {
        return Leader.builder()
                .leaderName("James")
                .surname("Hetfield")
                .build();
    }
}