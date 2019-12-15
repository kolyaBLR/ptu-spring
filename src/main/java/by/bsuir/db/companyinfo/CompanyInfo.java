package by.bsuir.db.companyinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companyinfo")
public class CompanyInfo {

    @Id
    @Column(name = "idCompanyInfo")
    private String id;

    @Column(name = "capital")
    private int capital;

    @Column(name = "dues")
    private int dues;

    @Column(name = "cleanProfit")
    private int cleanProfit;

    @Column(name = "amortizationDeduction")
    private int amortizationDeduction;

    @Column(name = "assets")
    private int assets;

    @Column(name = "idCompany_compInfo")
    private int companyId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getDues() {
        return dues;
    }

    public void setDues(int dues) {
        this.dues = dues;
    }

    public int getCleanProfit() {
        return cleanProfit;
    }

    public void setCleanProfit(int cleanProfit) {
        this.cleanProfit = cleanProfit;
    }

    public int getAmortizationDeduction() {
        return amortizationDeduction;
    }

    public void setAmortizationDeduction(int amortizationDeduction) {
        this.amortizationDeduction = amortizationDeduction;
    }

    public int getAssets() {
        return assets;
    }

    public void setAssets(int assets) {
        this.assets = assets;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
