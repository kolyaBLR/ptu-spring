package by.bsuir;

import by.bsuir.db.company.Company;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HomeControllerTest {

    @Test
    public void graph() {
        HomeController controller = new HomeController();
        ArrayList<Company> companies = new ArrayList<>();
        Company company = new Company();
        company.setName("APP");
        companies.add(company);
        companies.add(company);
        String script = controller.getGraphScript(companies);
        assertTrue(script.compareTo("[DATA]") != 0);
    }

    @Test
    public void graph_1() {
        HomeController controller = new HomeController();
        ArrayList<Company> companies = new ArrayList<>();
        Company company = new Company();
        company.setUserLogin("MANYA");
        companies.add(company);
        companies.add(company);
        String script = controller.getUsersGraphScript(companies);
        assertTrue(script.compareTo("[DATA]") != 0);
    }
}