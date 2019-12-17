package by.bsuir

import by.bsuir.model.CompanyModel

class CalculatorKotlin {

    fun execute(model: CompanyModel) {
        model.companyInfo.assets = model.product.numOfReleaseOf * model.product.costOfUnit
        model.companyInfo.amortizationDeduction = (
                (model.equipment.amortizationCostOfUnit * model.equipment.quantity)
                        + (model.employee.middleSalaryForUnit * model.employee.quantity)
                        + (model.placement.quantity * model.placement.rentPriceForYear)
                        + (model.product.costRawForUnit * model.product.numOfReleaseOf)
                )
        model.companyInfo.cleanProfit = model.companyInfo.assets -
                (model.companyInfo.amortizationDeduction + model.companyInfo.dues)
        val a2 = 1 + (model.companyInfo.amortizationDeduction / model.companyInfo.assets.toDouble())
        val a3 = model.companyInfo.capital + (model.companyInfo.cleanProfit / a2)
        model.company.cost = a3.toInt()
    }
}
