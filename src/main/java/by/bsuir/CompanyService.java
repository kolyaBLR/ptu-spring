package by.bsuir;

import by.bsuir.db.company.Company;
import by.bsuir.db.company.CompanyRepository;
import by.bsuir.model.UserModel;
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

    public List<Company> getAll() {
        return companyRepository.readAll(Company.class);
    }

    public Company getCompany(int companyId) {
        return companyRepository.read(companyId, Company.class);
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
        companyRepository.delete(id, Company.class);
    }

    public void insertOrUpdate(Company company) {
        if (company.getId() == 0) {
            company.setId(random.nextInt());
            companyRepository.create(company);
        } else {
            companyRepository.update(company);
        }
    }

    public static Validator getCompanyValidator() {
        return new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return Company.class.equals(aClass);
            }

            @Override
            public void validate(Object o, Errors errors) {
                for (String field : new String[]{"name", "cost"})
                    ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "field.empty");
            }
        };
    }
}
