package by.bsuir.db.placement;

import by.bsuir.db.CRUD;
import by.bsuir.db.SimpleCRUD;
import by.bsuir.db.companyinfo.CompanyInfo;
import org.springframework.stereotype.Repository;

@Repository
public class PlacementRepository extends SimpleCRUD<Placement, String> implements CRUD<Placement, String> {
}
