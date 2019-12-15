package by.bsuir.model;

import by.bsuir.db.company.Company;
import by.bsuir.db.companyinfo.CompanyInfo;
import by.bsuir.db.employee.Employee;
import by.bsuir.db.equipment.Equipment;
import by.bsuir.db.placement.Placement;
import by.bsuir.db.product.Product;

public class CompanyModel {

    private Company company = new Company();
    private CompanyInfo companyInfo = new CompanyInfo();
    private Employee employee = new Employee();
    private Equipment equipment = new Equipment();
    private Placement placement = new Placement();
    private Product product = new Product();

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
