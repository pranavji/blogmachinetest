package blog.services;

import blog.Globals;
import blog.models.User;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class UserServiceStubImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsernameAndPasswordHash(username, password);
        if (user == null)
            return false;
        else {
            Globals.CURRENT_USER=user;
            return true;
        }
    }

    @Override
    public void register(String username, String password) {
        User user = new User();

        user.setUsername(username);
        user.setPasswordHash(password);
        userRepository.save(user);
        Globals.CURRENT_USER=user;
    }
}