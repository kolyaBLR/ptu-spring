package by.bsuir.db;

import by.bsuir.model.CompanyModel;

public class Calculator {

    public void execute(CompanyModel model) {
        model.getCompanyInfo().setAssets(
                model.getProduct().getNumOfReleaseOf()
                        * model.getProduct().getCostOfUnit()
        );
        model.getCompanyInfo().setAmortizationDeduction(
                (model.getEquipment().getAmortizationCostOfUnit()
                        * model.getEquipment().getQuantity()) +
                        (model.getEmployee().getMiddleSalaryForUnit()
                                * model.getEmployee().getQuantity()) +
                        (model.getPlacement().getQuantity()
                                * model.getPlacement().getRentPriceForYear()) +
                        (model.getProduct().getCostRawForUnit()
                                * model.getProduct().getNumOfReleaseOf())
        );
        model.getCompanyInfo().setCleanProfit(
                model.getCompanyInfo().getAssets() -
                        (model.getCompanyInfo().getAmortizationDeduction()
                                + model.getCompanyInfo().getDues())
        );
        Double a2 = 1 + (model.getCompanyInfo().getAmortizationDeduction()
                / Double.valueOf(model.getCompanyInfo().getAssets() + ""));
        Double a3 = model.getCompanyInfo().getCapital()
                + (model.getCompanyInfo().getCleanProfit() / a2);
        model.getCompany().setCost(a3.intValue());
    }
}
