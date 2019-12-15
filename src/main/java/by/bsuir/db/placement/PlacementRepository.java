package by.bsuir.db.placement;

import by.bsuir.db.CRUD;
import by.bsuir.db.SimpleCRUD;
import by.bsuir.db.companyinfo.CompanyInfo;
import by.bsuir.db.equipment.Equipment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlacementRepository extends SimpleCRUD<Placement, String> implements CRUD<Placement, String> {

    @Override
    public Placement findFirst(Integer companyId) {
        List<Placement> items = readAll(Placement.class);
        for (Placement item : items) {
            if (item.getCompanyId() == companyId) {
                return item;
            }
        }
        return null;
    }
}
