package com.example.worldphonenew.controller;

import com.example.worldphonenew.dto.LoginDto;
import com.example.worldphonenew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @author: hieu
 * @since: 23/01/2024
 * Project_name: com.example.worldphonenew.controller
 */
@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserService iUserService;

    @PostMapping("/login")
    public String authenticate(@RequestBody LoginDto loginDto) {
        return iUserService.login(loginDto);//adminPassword
    }
}
