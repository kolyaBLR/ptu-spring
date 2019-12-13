package by.bsuir.db.enterpriseproduct;

import by.bsuir.db.SimpleCRUD;
import by.bsuir.db.enterprise.Enterprise;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnterpriseProductHiber extends SimpleCRUD<EnterpriseProduct, EnterpriseProductPK> implements EnterpriseProductDAO {
    @Override
    public List<EnterpriseProduct> readAllFor(Enterprise enterprise) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select ep from EnterpriseProduct ep where ep.enterpriseProductPK.enterprise.registrationId = :regId");
        query.setParameter("regId", enterprise.getRegistrationId());
        return query.list();
    }
}
