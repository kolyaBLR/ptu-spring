package by.bsuir

import by.bsuir.db.Calculator
import by.bsuir.model.CompanyModel

import org.junit.Assert.*

class CalculatorTest {

    @org.junit.Test
    fun execute() {
        val model = CompanyModel()
        model.product.costRawForUnit = 3
        model.product.costOfUnit = 8
        model.product.numOfReleaseOf = 1000
        model.employee.quantity = 5
        model.employee.middleSalaryForUnit = 100
        model.placement.costOfUnit = 1000
        model.placement.rentPriceForYear = 100
        model.placement.quantity = 3
        model.equipment.costOfUnit = 500
        model.equipment.amortizationCostOfUnit = 200
        model.equipment.quantity = 10
        model.companyInfo.dues = 800
        model.companyInfo.capital = 8000

        val calculator = Calculator()
        calculator.execute(model)

        assertEquals(8000, model.companyInfo.assets)
        assertEquals(5800, model.companyInfo.amortizationDeduction)
        assertEquals(1400, model.companyInfo.cleanProfit)
        assertEquals(8811, model.company.cost)
    }
}