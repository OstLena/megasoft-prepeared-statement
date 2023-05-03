import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class DatabaseQueryService implements DatabaseService {
    public static void main(String[] args) {

        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        List<MaxProjectCountClient> maxProjectsClient = databaseQueryService.findQueryResult("sql/find_max_projects_client.sql", rs -> {
            try {
                String name = rs.getString("name");
                int projectCount = rs.getInt("project_count");
                return new MaxProjectCountClient(name, projectCount);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        List<MaxSalaryWorker> maxSalaryWorkers = databaseQueryService.findQueryResult("sql/find_max_salary_worker.sql", rs -> {
            try {
                String name = rs.getString("name");
                BigDecimal salary = rs.getBigDecimal("salary");
                return new MaxSalaryWorker(name, salary);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


/*

        pstmt = con.prepareStatement(
                "SELECT EMPNO, PHONENO FROM EMPLOYEE WHERE EMPNO=?");
        // Create a PreparedStatement object    1
        pstmt.setString(1,"000010");      // Assign value to input parameter      2

        rs = pstmt.executeQuery();        // Get the result table from the query  3
        while (rs.next()) {               // Position the cursor                  4
            empnum = rs.getString(1);        // Retrieve the first column value
            phonenum = rs.getString(2);      // Retrieve the first column value
            System.out.println("Employee number = " + empnum +
                    "Phone number = " + phonenum);
            // Print the column values
        }
        rs.close();                       // Close the ResultSet                  5
        pstmt.close();                    // Close the PreparedStatement          6

*/

        List<LongestProject> longestProjects = databaseQueryService.findQueryResult("sql/find_longest_project.sql", rs -> {
            try {
                Long id = rs.getLong("id");
                int monthCount = rs.getInt("month_count");
                return new LongestProject(id, monthCount);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });


        List<WorkerWithAge> workerWithAges = databaseQueryService.findQueryResult("sql/find_youngest_eldest_workers.sql", rs -> {
            try {
                String type = rs.getString("type");
                String name = rs.getString("name");
                Date birthday = rs.getDate("birthday");
                return new WorkerWithAge(type, name, birthday);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        List<ProjectWithPrice> projectWithPrices = databaseQueryService.findQueryResult("sql/print_project_prices.sql", rs -> {
            try {
                Long id = rs.getLong("project_id");
                BigDecimal price = rs.getBigDecimal("price").setScale(2);
                return new ProjectWithPrice(id, price);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

//        maxProjectsClient.forEach(System.out::println);
        maxSalaryWorkers.forEach(System.out::println);
//        longestProjects.forEach(System.out::println);
//        workers.forEach(System.out::println);
//        projects.forEach(System.out::println);

    }

    <T> List<T> findQueryResult(String path, Function<ResultSet, T> map) {
        String query = getSQLScript(path);
        try (Connection conn = Database.getInstance().getConnection()) {
//            System.out.println(conn);
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            List<T> result = new ArrayList<>();
            while (rs.next()) {
                T pojo = map.apply(rs);
                result.add(pojo);
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
