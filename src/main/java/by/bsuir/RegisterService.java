package by.bsuir;

import by.bsuir.db.baseuser.BaseUser;
import by.bsuir.db.baseuser.BaseUserDAO;
import by.bsuir.db.password.PasswordDAO;
import by.bsuir.db.taggeditem.TaggedItem;
import by.bsuir.db.user.User;
import by.bsuir.db.user.UserDAO;
import by.bsuir.db.user.UserRepository;
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
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.create(user);
    }

    public boolean hasUser(String login) {
        return userRepository.read(login, User.class) != null;
    }

    public static Validator getUserValidator(final RegisterService registerService) {
        return new Validator() {
            @Override
            public boolean supports(Class<?> aClass) {
                return BaseUser.class.equals(aClass);
            }

            @Override
            public void validate(Object o, Errors errors) {
                for (String field : new String[]{"user.login", "user.password"})
                    ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "field.empty");

                User user = (User) o;
                if (!user.getLogin().matches("\\w+"))
                    errors.rejectValue("user.login", "field.invalid");
                if (registerService.hasUser(user.getLogin()))
                    errors.rejectValue("user.login", "field.taken");
            }
        };
    }
}
