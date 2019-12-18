package by.bsuir;

import by.bsuir.db.company.Company;
import by.bsuir.db.user.User;
import by.bsuir.model.UserGraphModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String empty() {
        return "redirect:/home";
    }

    @RequestMapping(value = "home", method = RequestMethod.GET)
    String home(Model model, HttpSession session) {
        User activeUser = userService.getActiveUser(session);
        if (activeUser == null) {
            return "redirect:/login";
        }
        List<User> users = userService.getUsers();
        List<Company> companies = companyService.findAll(activeUser.getLogin());
        model.addAttribute("activeUser", activeUser);
        model.addAttribute("users", users);
        model.addAttribute("companies", companies);
        model.addAttribute("graphScript", getGraphScript(companies));
        model.addAttribute("usersGraphScript", getUsersGraphScript(companyService.findAll()));
        return "home";
    }

    public String getGraphScript(List<Company> companies) {
        String item = "['[NAME]', [VALUE],";
        String items = "";
        for (Company company : companies) {
            if (company.getCost() > 0) {
                items += item.replace("[NAME]", company.getName()).replace("[VALUE]",
                        company.getCost() + "]");
            }
        }
        String data = "google.charts.load('current', {'packages': ['corechart']});\n" +
                "        google.charts.setOnLoadCallback(drawChart);\n" +
                "\n" +
                "        function drawChart() {\n" +
                "            var data = new google.visualization.DataTable();\n" +
                "            data.addColumn('string', 'Topping');\n" +
                "            data.addColumn('number', 'Slices');\n" +
                "            data.addRows([\n" +
                "                [DATA]\n" +
                "            ]);\n" +
                "\n" +
                "            // Set chart options\n" +
                "            var options = {\n" +
                "                'title': 'Цены ваших компаний (в процентах)',\n" +
                "                'width': 700,\n" +
                "                'height': 700\n" +
                "            };\n" +
                "            var chart = new google.visualization.PieChart(document.getElementById('chart_div'));\n" +
                "            chart.draw(data, options);\n" +
                "        }";
        return data.replace("[DATA]", items);
    }

    public String getUsersGraphScript(List<Company> companies) {
        HashMap<String, Integer> users = new HashMap<>();
        for (Company company : companies) {
            Integer value = users.get(company.getUserLogin());
            if (value == null) {
                value = 0;
            }
            users.put(company.getUserLogin(), value + company.getCost());
        }
        String item = "['[NAME]', [VALUE],";
        String items = "";
        for (Map.Entry<String, Integer> stringIntegerEntry : users.entrySet()) {
            String key = stringIntegerEntry.getKey();
            int value = stringIntegerEntry.getValue();
            if (value > 0) {
                items += item.replace("[NAME]", key).replace("[VALUE]", value + "]");
            }
        }
        String data = "google.charts.load(\"current\", {packages:[\"corechart\"]});\n" +
                "        google.charts.setOnLoadCallback(drawChart1);\n" +
                "        function drawChart1() {\n" +
                "            var data = google.visualization.arrayToDataTable([\n" +
                "                ['Пользователь', 'Общий копитал его кампаний'],\n" +
                "                [DATA]\n" +
                "            ]);\n" +
                "\n" +
                "            var options = {\n" +
                "                title: 'Капитал каждого пользователя (в процентах)',\n" +
                "                is3D: true,\n" +
                "            };\n" +
                "\n" +
                "            var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));\n" +
                "            chart.draw(data, options);\n" +
                "        }";

        return data.replace("[DATA]", items);
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    String deleteCompany(Model model, HttpSession session, Company companyModel) {
        User activeUser = userService.getActiveUser(session);
        if (activeUser == null) {
            return "redirect:/login";
        }
        companyService.delete(companyModel.getId());
        return "redirect:/home";
    }
}
