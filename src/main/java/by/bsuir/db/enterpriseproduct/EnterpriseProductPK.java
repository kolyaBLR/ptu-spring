package by.bsuir.db.enterpriseproduct;

import by.bsuir.db.enterprise.Enterprise;
import by.bsuir.db.product.Product;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnterpriseProductPK implements Serializable {
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ENTERPRISE")
    private Enterprise enterprise;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT")
    private Product product;

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof EnterpriseProductPK)) return false;
        return this.enterprise.equals(((EnterpriseProductPK) obj).enterprise)
                && this.product.equals(((EnterpriseProductPK) obj).product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enterprise, product);
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
