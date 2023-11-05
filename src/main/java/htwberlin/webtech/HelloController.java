package htwberlin.webtech;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "TestTest";
    }

    @RequestMapping("/test")
        public String test() {
            return "Testetsas";
        }

}
