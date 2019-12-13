package by.bsuir.db.projectproduct;

import by.bsuir.db.product.Product;
import by.bsuir.db.project.Project;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProjectProductPK implements Serializable {
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROJECT")
    private Project project;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT")
    private Product product;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof ProjectProductPK)) return false;
        return this.project.equals(((ProjectProductPK) obj).project)
                && this.product.equals(((ProjectProductPK) obj).product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project, product);
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
