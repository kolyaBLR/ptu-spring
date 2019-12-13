package by.bsuir.db.password;

import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

@Repository
public class PasswordHiber extends SimpleCRUD<Password, String> implements PasswordDAO {
}
