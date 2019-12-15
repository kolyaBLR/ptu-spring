package by.bsuir.db.companyinfo;

import by.bsuir.db.CRUD;
import by.bsuir.db.SimpleCRUD;
import by.bsuir.db.company.Company;
import by.bsuir.db.placement.Placement;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyInfoRepository extends SimpleCRUD<CompanyInfo, String> implements CRUD<CompanyInfo, String> {

    @Override
    public CompanyInfo findFirst(Integer companyId) {
        List<CompanyInfo> items = readAll(CompanyInfo.class);
        for (CompanyInfo item : items) {
            if (item.getCompanyId() == companyId) {
                return item;
            }
        }
        return null;
    }
}
