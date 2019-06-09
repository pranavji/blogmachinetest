package blog.services;

public interface UserService {
    boolean authenticate(String username, String password);

    void register(String username, String password);
}