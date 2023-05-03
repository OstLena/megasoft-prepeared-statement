import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class DatabasePopulateService implements DatabaseService {

    public static void main(String[] args) {

        try (Connection conn = Database.getInstance().getConnection()) {

            populateWorker(conn);
            populateClient(conn);
            populateProject(conn);
            populateProjectWorker(conn);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void populateWorker(Connection conn) throws SQLException {
        Worker[] workers = {
                new Worker("Gregor", Date.valueOf("2000-01-01"), "Trainee", BigDecimal.valueOf(1500)),
                new Worker("Max", Date.valueOf("1998-11-30"), "Junior", BigDecimal.valueOf(2000)),
                new Worker("Helen", Date.valueOf("1999-02-13"), "Middle", BigDecimal.valueOf(2500)),
                new Worker("Robert", Date.valueOf("2000-06-21"), "Senior", BigDecimal.valueOf(3800)),
                new Worker("Rose", Date.valueOf("1998-07-30"), "Trainee", BigDecimal.valueOf(1100)),
                new Worker("Debora", Date.valueOf("1991-01-12"), "Junior", BigDecimal.valueOf(2050)),
                new Worker("Rhone", Date.valueOf("1998-10-03"), "Middle", BigDecimal.valueOf(3400)),
                new Worker("Steve", Date.valueOf("1995-04-29"), "Senior", BigDecimal.valueOf(4800)),
                new Worker("Mike", Date.valueOf("2000-03-06"), "Junior", BigDecimal.valueOf(2800)),
                new Worker("Lois", Date.valueOf("1990-06-08"), "Senior", BigDecimal.valueOf(5000)),
                new Worker("Naomi", Date.valueOf("1994-12-17"), "Trainee", BigDecimal.valueOf(1000)),

        };

        PreparedStatement statement = conn.prepareStatement("insert into worker(name, birthday, level, salary)\n" +
                "values (?, ?, ?, ?)");

        for (Worker worker : workers) {
            statement.setString(1, worker.getName());
            statement.setDate(2, worker.getBirthday());
            statement.setString(3, worker.getLevel());
            statement.setBigDecimal(4, worker.getSalary());

            statement.addBatch();
        }
        int[] executeResult = statement.executeBatch();
        System.out.println("Execute result = " + executeResult);
    }

    private static void populateClient(Connection conn) throws SQLException {
        Client[] clients = {
                new Client("Mr.Simspon"),
                new Client("Ms.Hamilton"),
                new Client("Mr.Max"),
                new Client("Mr.Johnson"),
                new Client("Ms.Atkinson"),
        };

        PreparedStatement statement = conn.prepareStatement("insert into client(name) values (?)");

        for (Client client : clients) {
            statement.setString(1, client.getName());

            statement.addBatch();
        }
        int[] executeResult = statement.executeBatch();
        System.out.println("Execute result = " + executeResult);
    }

    private static void populateProjectWorker(Connection conn) throws SQLException {
        ProjectWorker[] projectWorkers = {
                new ProjectWorker(1L, 1L),
                new ProjectWorker(1L, 2L),
                new ProjectWorker(1L, 3L),
                new ProjectWorker(2L, 4L),
                new ProjectWorker(2L, 11L),
                new ProjectWorker(3L, 6L),
                new ProjectWorker(3L, 7L),
                new ProjectWorker(3L, 8L),
                new ProjectWorker(3L, 10L),
                new ProjectWorker(4L, 1L),
                new ProjectWorker(4L, 6L),
                new ProjectWorker(4L, 8L),
                new ProjectWorker(4L, 9L),
                new ProjectWorker(5L, 5L),
                new ProjectWorker(6L, 9L),
                new ProjectWorker(6L, 10L),
                new ProjectWorker(7L, 4L),
                new ProjectWorker(7L, 7L),
                new ProjectWorker(7L, 8L),
                new ProjectWorker(8L, 2L),
                new ProjectWorker(8L, 3L),
                new ProjectWorker(8L, 10L),
                new ProjectWorker(9L, 5L),
                new ProjectWorker(9L, 6L),
                new ProjectWorker(9L, 7L),
                new ProjectWorker(9L, 8L),
                new ProjectWorker(9L, 10L),
                new ProjectWorker(10L, 4L),
                new ProjectWorker(11L, 1L),
                new ProjectWorker(11L, 9L),
                new ProjectWorker(12L, 2L),
                new ProjectWorker(12L, 11L),

        };

        PreparedStatement statement = conn.prepareStatement("insert into project_worker(project_id, worker_id)" +
                "values (?, ?)");

        for (ProjectWorker projectWorker : projectWorkers) {
            statement.setLong(1, projectWorker.getProjectId());
            statement.setLong(2, projectWorker.getWorkerId());

            statement.addBatch();
        }
        int[] executeResult = statement.executeBatch();
        System.out.println("Execute result = " + executeResult);
    }


    private static void populateProject(Connection conn) throws SQLException {
        Project[] projects = {
                new Project(1L, Date.valueOf("2022-10-03"), Date.valueOf("2023-10-03")),
                new Project(2L, Date.valueOf("2022-01-03"), Date.valueOf("2023-09-28")),
                new Project(3L, Date.valueOf("2023-11-03"), Date.valueOf("2025-11-15")),
                new Project(5L, Date.valueOf("2022-08-12"), Date.valueOf("2023-12-21")),
                new Project(1L, Date.valueOf("2023-05-01"), Date.valueOf("2023-10-30")),
                new Project(2L, Date.valueOf("2023-08-20"), Date.valueOf("2026-08-20")),
                new Project(3L, Date.valueOf("2021-12-31"), Date.valueOf("2024-01-01")),
                new Project(4L, Date.valueOf("2022-09-01"), Date.valueOf("2023-08-20")),
                new Project(5L, Date.valueOf("2021-11-01"), Date.valueOf("2023-10-03")),
                new Project(1L, Date.valueOf("2022-10-06"), Date.valueOf("2024-10-06")),
                new Project(3L, Date.valueOf("2023-01-31"), Date.valueOf("2023-07-30")),
                new Project(5L, Date.valueOf("2023-04-01"), Date.valueOf("2026-03-03")),
        };

        PreparedStatement statement = conn.prepareStatement("insert into project(client_id, start_date, finish_date) " +
                "values (?, ?, ?)");

        for (Project project : projects) {
            statement.setLong(1, project.getId());
            statement.setDate(2, project.getStartDate());
            statement.setDate(3, project.getFinishDate());

            statement.addBatch();
        }
        int[] executeResult = statement.executeBatch();
        System.out.println("Execute result = " + executeResult);
    }
}
