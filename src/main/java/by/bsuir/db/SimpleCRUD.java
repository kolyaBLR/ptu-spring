package by.bsuir.db;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class SimpleCRUD<Model, Key> implements CRUD<Model, Key>{
    @Autowired
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Model model)
    {
        if (model == null)
            return;
        sessionFactory.getCurrentSession().persist(model);
    }

    public Model read(Key key, Class<Model> modelClass)
    {
        if (key == null)
            return null;
        return sessionFactory.getCurrentSession().get(modelClass, (Serializable) key);
    }

    public void update(Model model)
    {
        if (model == null)
            return;
        sessionFactory.getCurrentSession().update(model);
    }

    public void delete(Key key, Class<Model> modelClass)
    {
        if (key == null)
            return;
        sessionFactory.getCurrentSession().delete(read(key, modelClass));
    }

    public List<Model> readAll(Class<Model> modelClass)
    {
        return sessionFactory.getCurrentSession().createQuery("from " + modelClass.getSimpleName()).list();
    }
}
