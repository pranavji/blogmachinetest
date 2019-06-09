package blog.services;

import blog.Utils.PasswordHasher;
import blog.models.User;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class UserServiceStubImpl implements UserService {

    @Autowired
    HttpSession session;

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password) {
        password = PasswordHasher.hash(password);
        User user = userRepository.findByUsernameAndPasswordHash(username, password);
        if (user == null)
            return false;
        else {
            session.setAttribute("user", user);

            return true;
        }
    }

    @Override
    public void register(String username, String password) {
        User user = new User();
        password = PasswordHasher.hash(password);
        user.setUsername(username);
        user.setPasswordHash(password);
        userRepository.save(user);
        session.setAttribute("user", user);
    }
}