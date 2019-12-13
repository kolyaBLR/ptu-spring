package by.bsuir.db.enterprise;

import by.bsuir.db.SimpleCRUD;
import by.bsuir.db.baseuser.BaseUser;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnterpriseHiber extends SimpleCRUD<Enterprise, String> implements EnterpriseDAO {
    @Override
    public List<Enterprise> getAllNotApproved() {
        return sessionFactory.getCurrentSession().createQuery("select e from Enterprise e where e.approvedBy is null").list();
    }

    @Override
    public List<Enterprise> getAllFor(BaseUser baseUser) {
        Query query = sessionFactory.getCurrentSession().createQuery("select e from Enterprise e where e.owner.login = :login");
        query.setParameter("login", baseUser.getLogin());
        return query.list();
    }
}
