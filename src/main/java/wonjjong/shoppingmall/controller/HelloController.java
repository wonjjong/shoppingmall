package wonjjong.shoppingmall.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wonjjong.shoppingmall.service.MemberService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HelloController {

    private final MemberService memberService;

    @GetMapping("/")
    public String main() {
        log.info("main method");
        return "index";
    }

    @GetMapping("/status_code")
    @ResponseBody
    public String statusCodeTest(){
        return "statuscode test";
    }

    @GetMapping("/security-test")
    public String securityTest() {
        log.info("securityTest method");
        return "securityTest";
    }

}
