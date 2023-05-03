public class LongestProject {
    private Long id;

    private int monthCount;
    public LongestProject(Long id, int monthCount) {
        this.id = id;
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "name='" + id + '\'' +
                ", monthCount=" + monthCount +
                '}';
    }
}
