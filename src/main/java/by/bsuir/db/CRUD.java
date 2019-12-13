package by.bsuir.db;

import java.util.List;

public interface CRUD<Model, Key> {
    void create(Model model);

    Model read(Key key, Class<Model> modelClass);

    void update(Model model);

    void delete(Key key, Class<Model> modelClass);

    List<Model> readAll(Class<Model> modelClass);
}
