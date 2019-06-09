package blog.forms;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Size;

public class PostForm {

    @Size(min = 2, max = 30,
            message = "Need a title")
    private String title;


    @Size(min = 3)
    @NotNull
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
