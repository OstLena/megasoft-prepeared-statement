public class ProjectWorker {
    private Long projectId;

    private Long workerId;

    public ProjectWorker(Long projectId, Long workerId) {
        this.projectId = projectId;
        this.workerId = workerId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    @Override
    public String toString() {
        return "ProjectWorker{" +
                "projectId=" + projectId +
                ", workerId=" + workerId +
                '}';
    }
}
