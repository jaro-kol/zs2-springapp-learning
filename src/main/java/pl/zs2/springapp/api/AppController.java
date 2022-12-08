package pl.zs2.springapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping(value = "/app")
    public String app() {
        return "Spring app working!";
    }
}
