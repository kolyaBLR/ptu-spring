package by.bsuir.db.project;

import by.bsuir.db.SimpleCRUD;
import by.bsuir.db.baseuser.BaseUser;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectHiber extends SimpleCRUD<Project, Integer> implements ProjectDAO {

    @Override
    public List<Project> getAllCreatedBy(BaseUser baseUser) {
        Query query = sessionFactory.getCurrentSession().createQuery("select p from Project p where p.creator.login = :login");
        query.setParameter("login", baseUser.getLogin());
        return query.list();
    }
}
