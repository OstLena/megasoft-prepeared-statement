import java.util.Date;

public class WorkerWithAge {
    private String type;

    private String name;
    private Date birthday;

    public WorkerWithAge(String type, String name, Date birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
