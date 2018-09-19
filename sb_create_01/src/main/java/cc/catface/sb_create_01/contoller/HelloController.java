package cc.catface.sb_create_01.contoller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

@RestController
@EnableAutoConfiguration
public class HelloController {

    @RequestMapping("/helloSpringBoot")
    public String helloSpringBoot() {
        System.out.println("Hello SpringBoot");
        return "hello,this is a SpringBoot demo~~~by catface";
    }


    @RequestMapping("/helloWar")
    public String helloWar() {
        System.out.println("Hello war");
        return "hello,this is a war ~~~ by catface";
    }


    /**
     issue--注意
     1.使用@Controller注解并且在application.properties中配置好jsp目录
     2.使用idea运行后访问页面会出现Whitelabel Error Page & 解决->使用idea右侧Maven Projects->Plugins->spring-boot->:run运行后访问页面即可
     */
    @RequestMapping("/helloJsp")
    public String helloJsp(Model model) {
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }


    /** 统一错误页面 */
    @RequestMapping("/errorPage")
    public String errorPage() {
        int i = 1 / 0;
        return "end...";
    }
}