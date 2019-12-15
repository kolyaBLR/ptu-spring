package by.bsuir.db.user;

import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends SimpleCRUD<User, String> implements UserDAO {

    @Override
    public User findFirst(Integer companyId) {
        return null;
    }
}
