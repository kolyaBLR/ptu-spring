package by.bsuir.db.project;

import by.bsuir.db.CRUD;
import by.bsuir.db.baseuser.BaseUser;

import java.util.List;

public interface ProjectDAO extends CRUD<Project, Integer> {
    List<Project> getAllCreatedBy(BaseUser baseUser);
}
