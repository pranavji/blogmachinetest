package blog.services;

import blog.Globals;
import blog.models.Post;
import blog.models.User;
import blog.repositories.PostRepository;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PostServiceJpaImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findByAuthorId(Globals.CURRENT_USER.getId());
    }


    @Override
    public Post create(Post post) {
        return postRepo.save(post);
    }


}
