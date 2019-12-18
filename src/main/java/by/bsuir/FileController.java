package by.bsuir;

import by.bsuir.model.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequestMapping(value = "/files")
@Controller
public class FileController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("companyId") int companyId,
            HttpServletResponse response
    ) {
        String dir = "/Users/kolyablr/Documents/CrowdProjects/src/main/resources";
        String name = "result.txt";
        Path path = Paths.get(dir, name);
        File file = new File(dir, name);
        CompanyModel model = companyService.getCompany(companyId);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(
                    "Логин юзера: " + model.getCompany().getUserLogin() + "\n" +
                            "Название компании: " + model.getCompany().getName() + "\n" +
                            "Стоимость компании:" + model.getCompany().getCost() + "\n" +
                            "Чистая прибыль: " + model.getCompanyInfo().getCleanProfit() + "\n" +
                            "Амортизационные расходы: " + model.getCompanyInfo().getAmortizationDeduction() + "\n" +
                            "Налоги: " + model.getCompanyInfo().getDues() + "\n" +
                            "Активы: " + model.getCompanyInfo().getAssets() + "\n" +
                            "Капитал: " + model.getCompanyInfo().getCapital() + "\n" +
                            "Количество производимого продукта: : " + model.getProduct().getNumOfReleaseOf() + "\n" +
                            "Стомость производства единицы продукта: " + model.getProduct().getCostRawForUnit() + "\n" +
                            "Стоимость продажи единицы товара: " + model.getProduct().getCostOfUnit() + "\n" +
                            "Название продукта: " + model.getProduct().getNameProduct() + "\n" +
                            "Стоимость аренды помещения: " + model.getPlacement().getRentPriceForYear() + "\n" +
                            "Количество повещений: " + model.getPlacement().getQuantity() + "\n" +
                            "Название помещений: " + model.getPlacement().getName() + "\n" +
                            "Стоимость единицы помещения: " + model.getPlacement().getCostOfUnit() + "\n" +
                            "Количество работников: " + model.getEmployee().getQuantity() + "\n" +
                            "Средняя зарплата работника: " + model.getEmployee().getMiddleSalaryForUnit() + "\n" +
                            "Название должности: " + model.getEmployee().getPositionName() + "\n" +
                            "Количество оборудования: " + model.getEquipment().getQuantity() + "\n" +
                            "Название оборудования: " + model.getEquipment().getName() + "\n" +
                            "Стоимость содержания оборудования: " + model.getEquipment().getAmortizationCostOfUnit() + "\n" +
                            "Стоимость оборудования: " + model.getEquipment().getCostOfUnit()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Files.exists(path)) {
            response.setHeader("Content-disposition", "attachment;filename=" + name);
            response.setContentType("application/txt");
            try {
                Files.copy(path, response.getOutputStream());
                response.getOutputStream().flush();
            } catch (IOException e) {
            }
        }
    }
}
