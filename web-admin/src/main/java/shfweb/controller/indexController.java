package shfweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class indexController {

    @GetMapping("/index")
    public String index(){
        return "/frame/index";
    }


    @GetMapping("/main")
    public String main(){

        return "/frame/main";

    }

}
