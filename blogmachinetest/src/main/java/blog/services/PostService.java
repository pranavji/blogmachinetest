package blog.services;

import blog.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();


    Post create(Post post);

}
