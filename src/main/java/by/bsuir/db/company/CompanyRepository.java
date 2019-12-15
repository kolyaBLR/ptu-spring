package by.bsuir.db.company;

import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository extends SimpleCRUD<Company, Integer> implements CompanyDAO {

    @Override
    public Company findFirst(Integer companyId) {
        return read(companyId, Company.class);
    }
}
