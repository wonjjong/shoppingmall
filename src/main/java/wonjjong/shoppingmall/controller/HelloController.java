package wonjjong.shoppingmall.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wonjjong.shoppingmall.service.MemberService;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HelloController {


    private final MemberService memberService;

    /**
     *
     * ResponseBody test method
     */
    @ResponseBody
    @PostMapping("/events/requestBody")
    public Event eventRequestBody(@RequestBody Event event) {
        return event;
    }

    @ResponseBody
    @PostMapping("/events/modelAttribute")
    public Event eventModelAttribute(@ModelAttribute Event event) { return event;}

//    @GetMapping("/")
//    public String main() {
//        log.info("main method");
//        return "index";
//    }
    @GetMapping("/index")
    public String main() {
        log.info("main method");
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
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
