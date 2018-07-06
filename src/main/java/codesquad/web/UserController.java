package codesquad.web;

import codesquad.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    List<User> users = new ArrayList<>();

    // index 값이 동적으로 달라진다.
    @GetMapping("/users/{userId}")
    public String show(@PathVariable String userId, Model model) {
        for (User user : users) {
            if (user.getUserId().equals(userId))
                model.addAttribute("user", user);
        }
        return "/user/profile";
    }

    @PostMapping("/users")
    public String create(User user) {
        users.add(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String list(Model model) {
        model.addAttribute("users", users);
        return "/user/list";
    }
}
