package birdwatcher;

import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BirdWatcherWithSpring {

    private JdbcTemplate jdbcTemplate;

    public BirdWatcherWithSpring(MariaDbDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<String> getUniqueBirds() {
        return jdbcTemplate.query("SELECT DISTINCT `species` FROM `birds_spotted` ORDER BY `species`",
                (rs, i) -> rs.getString("species"));
    }
}
