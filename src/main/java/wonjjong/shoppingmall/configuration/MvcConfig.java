package wonjjong.shoppingmall.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@Slf4j
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/members/createMemberForm").setViewName("/members/createMemberForm");

        //addViewController for spring security view
        registry.addViewController("/manager/main").setViewName("managerMain");
        registry.addViewController("/admin/main").setViewName("adminMain");
        registry.addViewController("member/main").setViewName("memberMain");

    }

}
