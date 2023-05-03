import java.math.BigDecimal;
import java.sql.Date;


public class Worker {

    private String name;
    private Date birthday;
    private String level;
    private BigDecimal salary;

    public Worker(String name, Date birthday, String level, BigDecimal salary) {
        this.name = name;
        this.birthday = birthday;
        this.level = level;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getLevel() {
        return level;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", level='" + level + '\'' +
                ", salary=" + salary +
                '}';
    }
}
