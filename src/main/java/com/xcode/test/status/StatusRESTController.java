package com.xcode.test.status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusRESTController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
