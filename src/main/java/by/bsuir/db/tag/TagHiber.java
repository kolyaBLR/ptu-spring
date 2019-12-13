package by.bsuir.db.tag;

import by.bsuir.db.SimpleCRUD;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagHiber extends SimpleCRUD<Tag, TagPK> implements TagDAO {

    @Override
    public List<Tag> getTagsByName(String tag) {
        Query query = sessionFactory.getCurrentSession().createQuery("select t from Tag t where t.tagPK.tag = :tag");
        query.setParameter("tag", tag);
        return query.list();
    }

    @Override
    public List<Tag> getTagsByItem(Integer taggedItemId) {
        Query query = sessionFactory.getCurrentSession().createQuery("select t from Tag t where t.tagPK.taggedItem.id = :taggedItemId");
        query.setParameter("taggedItemId", taggedItemId);
        return query.list();
    }
}
