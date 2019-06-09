package blog.controllers;

import blog.Globals;
import blog.models.Post;
import blog.services.NotificationService;
import blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/")
    public String home(Model model) {

        if(Globals.CURRENT_USER==null)
        {
            return "redirect:/users/login";
        }
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);


        return "index";
    }

//    @RequestMapping("/posts/view/{id}")
//    public String view(@PathVariable("id") Long id,
//                       Model model) {
//        Post post = postService.findById(id);
//
//        if (post == null) {
//            notificationService.addErrorMessage(
//                    "Cannot find post: " + id);
//            return "redirect:/";
//        }
//
//        model.addAttribute("post", post);
//        return "/posts/index";
//    }

}