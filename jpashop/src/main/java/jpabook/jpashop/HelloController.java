package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) { // model에 정보를 담아서 view로 보낼 수 있음
        model.addAttribute("data", "hello!!!");
        return "hello"; // 자동으로 hello.html이 됨
    }
}
