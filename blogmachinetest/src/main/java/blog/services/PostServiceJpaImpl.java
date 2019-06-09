package blog.services;

import blog.models.Post;
import blog.models.User;
import blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Primary
public class PostServiceJpaImpl implements PostService {

    @Autowired
    HttpSession httpSession;

    @Autowired
    private PostRepository postRepo;

    @Override
    public List<Post> findAll() {
        return postRepo.findByAuthorId( (((User)httpSession.getAttribute("user")).getId()));
    }


    @Override
    public Post create(Post post) {
        return postRepo.save(post);
    }


}
