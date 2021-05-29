package birdwatcher;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BirdWatcher {

    private final MariaDbDataSource dataSource;

    public BirdWatcher(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getUniqueBirds() {
        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT DISTINCT `species` FROM `birds_spotted` ORDER BY `species`")
        ) {
            List<String> spottedBirds = new ArrayList<>();

            while (rs.next()) {
                String name = rs.getString("species");
                spottedBirds.add(name);
            }

            return spottedBirds;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect or query", sqle);
        }
    }
}
