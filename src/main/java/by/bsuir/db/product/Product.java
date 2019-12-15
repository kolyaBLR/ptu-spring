package by.bsuir.db.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nameProduct")
    private String nameProduct;

    @Column(name = "numOfReleaseOf")
    private int numOfReleaseOf;

    @Column(name = "costRawForUnit")
    private int costRawForUnit;

    @Column(name = "costOfUnit")
    private int costOfUnit;

    @Column(name = "idCompany_product")
    private int companyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getNumOfReleaseOf() {
        return numOfReleaseOf;
    }

    public void setNumOfReleaseOf(int numOfReleaseOf) {
        this.numOfReleaseOf = numOfReleaseOf;
    }

    public int getCostRawForUnit() {
        return costRawForUnit;
    }

    public void setCostRawForUnit(int costRawForUnit) {
        this.costRawForUnit = costRawForUnit;
    }

    public int getCostOfUnit() {
        return costOfUnit;
    }

    public void setCostOfUnit(int costOfUnit) {
        this.costOfUnit = costOfUnit;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
