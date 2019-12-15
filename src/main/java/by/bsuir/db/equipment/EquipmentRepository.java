package by.bsuir.db.equipment;

import by.bsuir.db.CRUD;
import by.bsuir.db.SimpleCRUD;
import org.springframework.stereotype.Repository;

@Repository
public class EquipmentRepository extends SimpleCRUD<Equipment, String> implements CRUD<Equipment, String> {
}
