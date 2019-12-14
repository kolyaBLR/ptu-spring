package by.bsuir;

import by.bsuir.db.user.User;
import by.bsuir.db.user.UserRepository;
import by.bsuir.model.UserModel;
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
                return UserModel.class.equals(aClass);
            }

            @Override
            public void validate(Object o, Errors errors) {
                for (String field : new String[]{"login", "password"})
                    ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, "field.empty");

                UserModel user = (UserModel) o;
                if (!user.getLogin().matches("\\w+"))
                    errors.rejectValue("login", "field.invalid");
                if (registerService.hasUser(user.getLogin()))
                    errors.rejectValue("login", "field.taken");
            }
        };
    }
}
