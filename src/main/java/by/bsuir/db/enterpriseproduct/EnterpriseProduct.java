package by.bsuir.db.enterpriseproduct;

import javax.persistence.*;

@Entity
@Table(name = "enterprise_product")
public class EnterpriseProduct {
    @EmbeddedId
    private EnterpriseProductPK enterpriseProductPK;

    @Column(name = "COST")
    private Integer cost;
    @Column(name = "AMOUNT")
    private Integer amount;

    public EnterpriseProductPK getEnterpriseProductPK() {
        return enterpriseProductPK;
    }

    public void setEnterpriseProductPK(EnterpriseProductPK enterpriseProductPK) {
        this.enterpriseProductPK = enterpriseProductPK;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
