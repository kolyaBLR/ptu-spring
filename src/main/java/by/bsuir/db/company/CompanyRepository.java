package by.bsuir.db.company;

import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepository extends SimpleCRUD<Company, Integer> implements CompanyDAO {
}
