package by.bsuir.db.projectproduct;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "project_product")
public class ProjectProduct {
    @EmbeddedId
    private ProjectProductPK projectProductPK;
    @Column(name = "REQUIRED")
    private Integer required;
    @Column(name = "RECEIVED")
    private Integer received;

    public ProjectProductPK getProjectProductPK() {
        return projectProductPK;
    }

    public void setProjectProductPK(ProjectProductPK projectProductPK) {
        this.projectProductPK = projectProductPK;
    }

    public Integer getRequired() {
        return required;
    }

    public void setRequired(Integer required) {
        this.required = required;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }
}
