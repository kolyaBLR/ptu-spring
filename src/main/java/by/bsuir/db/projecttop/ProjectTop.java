package by.bsuir.db.projecttop;

import by.bsuir.db.project.Project;

import javax.persistence.*;

@Entity
@Table(name = "project_top")
public class ProjectTop {
    @Id
    @Column(name = "PLACE")
    private Integer place;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT")
    private Project project;

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
