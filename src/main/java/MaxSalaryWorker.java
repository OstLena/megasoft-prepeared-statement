import java.math.BigDecimal;

public class MaxSalaryWorker {

    private String name;
    private BigDecimal salary;

    public MaxSalaryWorker(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
