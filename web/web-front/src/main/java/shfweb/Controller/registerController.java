package shfweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/register")
@Controller
public class registerController {

    @RequestMapping
    public String register(){
        return "register";
    }
}
