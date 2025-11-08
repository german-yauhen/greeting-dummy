package org.eugerman.greeting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    static final String GREETING_MSG_TEMPLATE = "Hello, %s, from dummy greeting application";
    static final String GREET_ULR = "/greet";

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(GREET_ULR)
    public String greeting(@RequestParam("name") String name) {
        return GREETING_MSG_TEMPLATE.formatted(name);
    }
}
