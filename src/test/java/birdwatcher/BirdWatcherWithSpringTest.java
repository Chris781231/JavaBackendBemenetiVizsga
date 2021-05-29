package birdwatcher;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfiguration.class)
class BirdWatcherWithSpringTest {

    private static final List<String> EXPECTED_SPECIES = List.of("american robin", "downy woodpecker", "house sparrow", "northern cardinal");

    @Autowired
    private BirdWatcherWithSpring birdWatcher;

    @Autowired
    private Flyway flyway;

    BirdWatcherWithSpringTest() {
    }

    @BeforeEach
    void init() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void test_getUniqueBirds_allBirdsOnce_anyOrder() {
        List<String> actualSpecies = birdWatcher.getUniqueBirds();

        assertEquals(EXPECTED_SPECIES.size(), actualSpecies.size());
        for (String bird : EXPECTED_SPECIES) {
            assertTrue(actualSpecies.contains(bird));
        }
    }
}