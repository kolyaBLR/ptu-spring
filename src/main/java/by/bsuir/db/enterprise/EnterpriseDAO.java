package by.bsuir.db.enterprise;

import by.bsuir.db.CRUD;
import by.bsuir.db.baseuser.BaseUser;

import java.util.List;

public interface EnterpriseDAO extends CRUD<Enterprise, String> {
    List<Enterprise> getAllNotApproved();
    List<Enterprise> getAllFor(BaseUser baseUser);
}
