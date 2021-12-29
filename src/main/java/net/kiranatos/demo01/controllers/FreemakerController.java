package net.kiranatos.demo01.controllers;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreemakerController {
    /*
    http://localhost:8090/hello
    http://localhost:8090//freemaker?name=Java Developer
    */    
    @GetMapping({"/hello", "/freemaker"})
    //@RequestMapping("/hello") <- тоже сработало
    public String showHelloWorld(Model model,
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        System.out.println("<<method showHelloWorld in class FreemakerController>>");        
        return "fm"; //fm.ftlh
    }
    
    /*
    @GetMapping // without ("") it's "http://localhost:8090/" or "/"
    public String homePageMethod(Map<String, Object> model) {        
        return "homefm";
    }*/
}