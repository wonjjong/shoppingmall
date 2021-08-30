package wonjjong.shoppingmall.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
/*
@EnableWebMvc 어노테이션을 붙여주면 스프링부트의 기본적인 웹 MVC 기능들을 제외시키고 처음부터 생성해야 하므로 빼주자
cant find the css and js files
 */
@Slf4j
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SimpleInterceptor())
                .excludePathPatterns("/css/**");
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/members/createMemberForm").setViewName("/members/createMemberForm");

        //addViewController for spring security view
        registry.addViewController("/manager/main").setViewName("managerMain");
        registry.addViewController("/admin/main").setViewName("adminMain");
        registry.addViewController("/member/main").setViewName("memberMain");

    }

}
