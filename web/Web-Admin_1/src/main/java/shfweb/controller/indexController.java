package shfweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
@EnableDubbo
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
