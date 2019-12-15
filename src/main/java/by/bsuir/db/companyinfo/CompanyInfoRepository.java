package by.bsuir.db.companyinfo;

import by.bsuir.db.CRUD;
import by.bsuir.db.SimpleCRUD;
import by.bsuir.db.placement.Placement;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyInfoRepository extends SimpleCRUD<CompanyInfo, String> implements CRUD<CompanyInfo, String> {
}
