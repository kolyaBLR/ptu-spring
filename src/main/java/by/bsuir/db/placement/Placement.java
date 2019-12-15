package by.bsuir.db.placement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placement")
public class Placement {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "rentPriceForYear")
    private int rentPriceForYear;

    @Column(name = "costOfUnit")
    private int costOfUnit;

    @Column(name = "idCompany_placement")
    private int companyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRentPriceForYear() {
        return rentPriceForYear;
    }

    public void setRentPriceForYear(int rentPriceForYear) {
        this.rentPriceForYear = rentPriceForYear;
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
