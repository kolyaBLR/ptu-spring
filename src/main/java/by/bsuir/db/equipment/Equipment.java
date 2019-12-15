package by.bsuir.db.equipment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amortizationCostOfUnit")
    private int amortizationCostOfUnit;

    @Column(name = "costOfUnit")
    private int costOfUnit;

    @Column(name = "idCompany_equipment")
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

    public int getAmortizationCostOfUnit() {
        return amortizationCostOfUnit;
    }

    public void setAmortizationCostOfUnit(int amortizationCostOfUnit) {
        this.amortizationCostOfUnit = amortizationCostOfUnit;
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
