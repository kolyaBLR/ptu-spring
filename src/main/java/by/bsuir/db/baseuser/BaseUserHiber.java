package by.bsuir.db.baseuser;

import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

@Repository
public class BaseUserHiber extends SimpleCRUD<BaseUser, String> implements BaseUserDAO {
}
