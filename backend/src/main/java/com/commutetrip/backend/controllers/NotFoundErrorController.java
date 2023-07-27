package com.commutetrip.backend.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotFoundErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        return "YOU ARE NOT ALLOWED! (there is nothing here)";
    }
}
