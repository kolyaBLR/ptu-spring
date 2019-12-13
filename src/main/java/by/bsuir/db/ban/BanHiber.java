package by.bsuir.db.ban;

import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

@Repository
public class BanHiber extends SimpleCRUD<Ban, String> implements BanDAO {
}
