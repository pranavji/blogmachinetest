package blog.controllers;

import blog.forms.PostForm;
import blog.models.Post;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.AttributedCharacterIterator;

@Controller
public class PostCreationController {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/users/createpost")
    public String register(PostForm postForm) {
        return "users/createpost";
    }

    @RequestMapping(value = "/users/createpost", method = RequestMethod.POST)
    public String registrationPage(@Valid PostForm postForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/createpost";
        }


        postService.create(
                new Post(postForm.getTitle(), postForm.getBody(),((User)httpSession.getAttribute("user"))));



        notifyService.addInfoMessage("Post added successful");
        return"redirect:/";
}
}