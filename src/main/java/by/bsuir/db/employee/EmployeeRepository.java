package by.bsuir.db.employee;

import by.bsuir.db.CRUD;
import by.bsuir.db.SimpleCRUD;
import by.bsuir.db.companyinfo.CompanyInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository extends SimpleCRUD<Employee, String> implements CRUD<Employee, String> {

    @Override
    public Employee findFirst(Integer companyId) {
        List<Employee> items = readAll(Employee.class);
        for (Employee item : items) {
            if (item.getCompanyId() == companyId) {
                return item;
            }
        }
        return null;
    }

}
