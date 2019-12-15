package by.bsuir.db.equipment;

import by.bsuir.db.CRUD;
import by.bsuir.db.SimpleCRUD;
import by.bsuir.db.employee.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EquipmentRepository extends SimpleCRUD<Equipment, String> implements CRUD<Equipment, String> {

    @Override
    public Equipment findFirst(Integer companyId) {
        List<Equipment> items = readAll(Equipment.class);
        for (Equipment item : items) {
            if (item.getCompanyId() == companyId) {
                return item;
            }
        }
        return null;
    }
}
