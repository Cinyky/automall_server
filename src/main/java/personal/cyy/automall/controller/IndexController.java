package personal.cyy.automall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.cyy.automall.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cinyky
 * @Date 11:53 2019-05-15
 */

@Controller
public class IndexController extends IController {

    @RequestMapping("/index")
    String template(Model model) {
        User user = new User("1", "wx1", 1);
        List<User> users = new ArrayList<>();
        User user1 = new User("2", "wx2", 2);
        User user2 = new User("3", "wx3", 3);
        users.add(user1);
        users.add(user2);
        model.addAttribute("user", user);
        model.addAttribute("users", users);
        return "index";
    }
}
