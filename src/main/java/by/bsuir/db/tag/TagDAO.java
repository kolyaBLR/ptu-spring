package by.bsuir.db.tag;

import by.bsuir.db.CRUD;

import java.util.List;

public interface TagDAO extends CRUD<Tag, TagPK> {

    List<Tag> getTagsByName(String tag);
    List<Tag> getTagsByItem(Integer taggedItemId);
}
