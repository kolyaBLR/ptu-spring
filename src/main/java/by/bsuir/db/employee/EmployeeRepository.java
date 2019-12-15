package by.bsuir.db.employee;

import by.bsuir.db.CRUD;
import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository extends SimpleCRUD<Employee, String> implements CRUD<Employee, String> {
}
