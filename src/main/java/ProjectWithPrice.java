import java.math.BigDecimal;

public class ProjectWithPrice {

    private Long id;
    private BigDecimal price;

    public ProjectWithPrice(Long id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + id + '\'' +
                ", price=" + price +
                '}';
    }
}
