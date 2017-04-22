package my.pack.controllers;

import my.pack.model.Sample;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @RequestMapping(value = "/sample", method = RequestMethod.GET)
    public Sample sample() {
        return new Sample("Welcome");
    }
}
