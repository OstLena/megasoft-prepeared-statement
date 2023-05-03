import java.sql.Date;

public class Project {

    private Long id;
    private Date startDate;
    private Date finishDate;

    public Project(Long id, Date startDate, Date finishDate) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public Long getId() {
        return id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
