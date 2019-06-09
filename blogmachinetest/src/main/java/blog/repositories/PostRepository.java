package blog.repositories;

import blog.models.Post;
import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends
        JpaRepository<Post, Long> {
   List<Post> findByAuthorId(Long user);

}

