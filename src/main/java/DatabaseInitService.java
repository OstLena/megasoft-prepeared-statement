public class DatabaseInitService implements DatabaseService {

    public static void main(String[] args) {
        DatabaseInitService service = new DatabaseInitService();
        service.executeScript(service.getSQLScript("sql/drop_db.sql"));
        service.executeScript(service.getSQLScript("sql/init_db.sql"));
    }
}
