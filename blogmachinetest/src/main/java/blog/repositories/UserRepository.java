package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {

    public User findByUsernameAndPasswordHash(String username, String password);
}
