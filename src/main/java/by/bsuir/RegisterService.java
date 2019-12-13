package by.bsuir;

import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.baseuser.BaseUserDAO;
import by.bsuir.db.password.PasswordDAO;
import by.bsuir.db.taggeditem.TaggedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
@Transactional
public class RegisterService {
    @Autowired
    private BaseUserDAO baseUserDAO;
    @Autowired
    private PasswordDAO passwordDAO;

    public void registerUser(BaseUser baseUser)
    {
        baseUser.setLogin(baseUser.getPassword().getLogin());
        baseUser.setTaggedItem(new TaggedItem());
        baseUserDAO.create(baseUser);
        passwordDAO.create(baseUser.getPassword());
    }

    public boolean hasUser(String login)
    {
        return baseUserDAO.read(login, BaseUser.class) != null;
    }

    public static Validator getUserValidator(final RegisterService registerService) {
        return new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return BaseUser.class.equals(aClass);
            }

            @Override
            public void validate(Object o, Errors errors) {
                for (String field : new String[]{"password.login", "password.password", "namedItem.name", "surname", "email"})
                    ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "field.empty");

                BaseUser baseUser = (BaseUser) o;
                if (!baseUser.getEmail().matches("(\\w+)@(\\w+).(\\w+)"))
                    errors.rejectValue("email", "field.invalid");
                if (!baseUser.getPassword().getLogin().matches("\\w+"))
                    errors.rejectValue("password.login", "field.invalid");
                if (baseUser.getBirthDay() == null)
                    errors.rejectValue("birthDay", "field.invalid");
                if (registerService.hasUser(baseUser.getPassword().getLogin()))
                    errors.rejectValue("password.login", "field.taken");
            }
        };
    }
}
