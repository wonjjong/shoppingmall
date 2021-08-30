package wonjjong.shoppingmall.configuration.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
//@EnableWebSecurity
/*
기본 설정을 무시하고 개발자가 지정한 설정을 우선 사용하도록 하는 것이 대부분의 경우 유용할 것입니다.
 스프링 부트는 사용자 정의 클래스를 발견하면 당연하게도 자동 설정보다 우선하여 동작하게 되어있습니다.
 */
public class WebSecurityConfig {
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
     The configure(HttpSecurity) method defines which URL paths should be secured and which should not.
     Specifically, the / and /home paths are configured to not require any authentication.
     All other paths must be authenticated.
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/members/createMemberForm")
//                .permitAll()
//                .failureUrl("/login-error")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/index")
//                .permitAll();
//    }




//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
//        manager.createUser(User.withUsername("wonjjong").password("password").roles("ROLE_ADMIN").build());
//        manager.createUser(User.withUsername("wjm358").password("password").roles("ROLE_MANAGER").build());
//        manager.createUser(User.withUsername("guest").password("password").roles("ROLE_GUEST").build());
//
//        return manager;
//
//        /*
//                UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//         */
//    }

}