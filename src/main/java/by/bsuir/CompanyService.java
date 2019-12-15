package by.bsuir;

import by.bsuir.db.company.Company;
import by.bsuir.db.company.CompanyRepository;
import by.bsuir.db.companyinfo.CompanyInfo;
import by.bsuir.db.companyinfo.CompanyInfoRepository;
import by.bsuir.db.employee.Employee;
import by.bsuir.db.employee.EmployeeRepository;
import by.bsuir.db.equipment.Equipment;
import by.bsuir.db.equipment.EquipmentRepository;
import by.bsuir.db.placement.Placement;
import by.bsuir.db.placement.PlacementRepository;
import by.bsuir.db.product.Product;
import by.bsuir.db.product.ProductRepository;
import by.bsuir.model.CompanyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class CompanyService {

    private Random random = new Random(System.currentTimeMillis());

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyInfoRepository companyInfoRepository;
    @Autowired
    private PlacementRepository placementRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Company> getAll() {
        return companyRepository.readAll(Company.class);
    }

    public CompanyModel getCompany(int companyId, String login) {
        CompanyModel companyModel = new CompanyModel();
        Company company = companyRepository.read(companyId, Company.class);
        if (company != null && company.getUserLogin().equals(login)) {
            companyModel.setCompany(company);
            companyModel.setCompanyInfo(companyInfoRepository.findFirst(companyId));
            companyModel.setPlacement(placementRepository.findFirst(companyId));
            companyModel.setEquipment(equipmentRepository.findFirst(companyId));
            companyModel.setProduct(productRepository.findFirst(companyId));
            companyModel.setEmployee(employeeRepository.findFirst(companyId));
            return companyModel;
        } else {
            return null;
        }
    }

    public List<Company> findAll(String login) {
        List<Company> all = companyRepository.readAll(Company.class);
        ArrayList<Company> result = new ArrayList<>();
        for (Company company : all) {
            if (company.getUserLogin().equals(login)) {
                result.add(company);
            }
        }
        return result;
    }

    public void delete(int id) {
        Company company = companyRepository.read(id, Company.class);
        if (company != null) {
            companyInfoRepository.delete(companyInfoRepository.findFirst(id).getId(), CompanyInfo.class);
            placementRepository.delete(placementRepository.findFirst(id).getId(), Placement.class);
            equipmentRepository.delete(equipmentRepository.findFirst(id).getId(), Equipment.class);
            productRepository.delete(productRepository.findFirst(id).getId(), Product.class);
            employeeRepository.delete(employeeRepository.findFirst(id).getId(), Employee.class);
            companyRepository.delete(id, Company.class);
        }
    }

    public static Validator getCompanyValidator() {
        return new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return CompanyModel.class.equals(aClass);
            }

            @Override
            public void validate(Object o, Errors errors) {
                /*for (String field : new String[]{"name", "cost"})
                    ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "field.empty");*/
            }
        };
    }

    public void insertOrUpdate(CompanyModel company, String login) {
        if (company.getCompany().getId() == 0) {
            int companyId = Math.abs(random.nextInt());
            company.getCompany().setId(companyId);

            company.getCompany().setUserLogin(login);

            company.getCompanyInfo().setId(UUID.randomUUID().toString());
            company.getPlacement().setId(UUID.randomUUID().toString());
            company.getEquipment().setId(UUID.randomUUID().toString());
            company.getProduct().setId(UUID.randomUUID().toString());
            company.getEmployee().setId(UUID.randomUUID().toString());

            company.getCompanyInfo().setCompanyId(companyId);
            company.getPlacement().setCompanyId(companyId);
            company.getEquipment().setCompanyId(companyId);
            company.getProduct().setCompanyId(companyId);
            company.getEmployee().setCompanyId(companyId);

            companyRepository.create(company.getCompany());
            companyInfoRepository.create(company.getCompanyInfo());
            placementRepository.create(company.getPlacement());
            equipmentRepository.create(company.getEquipment());
            productRepository.create(company.getProduct());
            employeeRepository.create(company.getEmployee());
        } else {
            companyRepository.update(company.getCompany());
            companyInfoRepository.update(company.getCompanyInfo());
            placementRepository.update(company.getPlacement());
            equipmentRepository.update(company.getEquipment());
            productRepository.update(company.getProduct());
            employeeRepository.update(company.getEmployee());
        }
    }
}
