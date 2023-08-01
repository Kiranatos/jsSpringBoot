package net.kiranatos.demo01.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
    /*
    http://localhost:8090/thymeleafurl
    http://localhost:8090/thymeleafurl?name=Kiranatos
    */
    @GetMapping("/thymeleafurl")
    public String greetingMethod(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model) {
        model.put("name", name);
        System.out.println("<<method greetingMethod in class ThymeleafController>>");
        return "tl"; // tl.html
    }
    
    
    @GetMapping // without ("") it's "http://localhost:8090/" or "/"
    public String homePageMethod(Map<String, Object> model) {        
        return "hometl";
    }
}