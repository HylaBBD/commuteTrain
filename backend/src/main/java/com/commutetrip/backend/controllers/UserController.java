package com.commutetrip.backend.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/id")
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
