package by.bsuir.db.projectproduct;

import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectProductHiber extends SimpleCRUD<ProjectProduct, ProjectProductPK> implements ProjectProductDAO {
}
