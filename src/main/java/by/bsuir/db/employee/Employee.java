package by.bsuir.db.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "positionName")
    private String positionName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "middleSeleryForUnit")
    private int middleSalaryForUnit;

    @Column(name = "idCompany")
    private int companyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMiddleSalaryForUnit() {
        return middleSalaryForUnit;
    }

    public void setMiddleSalaryForUnit(int middleSalaryForUnit) {
        this.middleSalaryForUnit = middleSalaryForUnit;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
