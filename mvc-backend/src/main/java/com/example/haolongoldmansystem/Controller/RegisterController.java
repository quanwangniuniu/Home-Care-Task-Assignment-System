package com.example.haolongoldmansystem.Controller;

import com.example.haolongoldmansystem.Entity.CommonHelper;
import com.example.haolongoldmansystem.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @PostMapping("/register")
    public CommonHelper register(@RequestBody CommonHelper commonHelper){
        registerService.register(commonHelper);
        return commonHelper;
    }
}
