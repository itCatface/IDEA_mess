package cc.catface.sb_create_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/** war方式 */
@SpringBootApplication
@ServletComponentScan
public class SbCreate01Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SbCreate01Application.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(SbCreate01Application.class, args);
    }
}

/** jar方式 */
//@SpringBootApplication
//public class SbCreate01Application {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SbCreate01Application.class, args);
//    }
//}