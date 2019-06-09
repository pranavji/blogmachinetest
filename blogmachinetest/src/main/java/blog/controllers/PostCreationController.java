package blog.controllers;

import blog.Globals;
import blog.forms.PostForm;
import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PostCreationController {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

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
                new Post(postForm.getTitle(), postForm.getBody(), Globals.CURRENT_USER));



        notifyService.addInfoMessage("Post added successful");
        return"redirect:/";
}
}