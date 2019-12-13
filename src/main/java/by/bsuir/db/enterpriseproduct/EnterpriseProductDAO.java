package by.bsuir.db.enterpriseproduct;

import by.bsuir.db.CRUD;
import by.bsuir.db.enterprise.Enterprise;

import java.util.List;

public interface EnterpriseProductDAO extends CRUD<EnterpriseProduct, EnterpriseProductPK> {
    List<EnterpriseProduct> readAllFor(Enterprise enterprise);
}
