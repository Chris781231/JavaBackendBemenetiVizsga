package birdwatcher;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class SpringConfiguration {

    @Bean
    public Flyway flyway() throws SQLException {
        Flyway flyway = Flyway.configure().dataSource(dataSource()).load();
        return flyway;
    }

    @Bean
    public MariaDbDataSource dataSource() throws SQLException {
        MariaDbDataSource dataSource;
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3308/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        return dataSource;
    }

    @Bean
    public BirdWatcherWithSpring birdWatcher() throws SQLException {
        return new BirdWatcherWithSpring(dataSource());
    }
}
