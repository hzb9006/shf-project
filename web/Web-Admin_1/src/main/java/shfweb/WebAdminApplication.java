package shfweb;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class WebAdminApplication {
    // todo: 此处会报循环依赖的错误，未解决！
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(WebAdminApplication.class);
        springApplication.setAllowCircularReferences(Boolean.TRUE);
        springApplication.run(args);

    }

}
