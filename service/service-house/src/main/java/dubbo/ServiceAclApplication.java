package dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "dubbo.mapper")// 不要忘记！！
public class ServiceAclApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ServiceAclApplication.class);
        springApplication.setAllowCircularReferences(Boolean.TRUE);
        springApplication.run(args);

    }

}
