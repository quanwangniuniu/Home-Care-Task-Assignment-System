package com.example.haolongoldmansystem.Controller;

import com.example.haolongoldmansystem.Entity.CommonHelper;
import com.example.haolongoldmansystem.Service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

//    @PostMapping("/commonhelperlogin")
//    public ResponseEntity<String> checkLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
//        System.out.println("username:  " + username + "password   " + password);
//        if (loginService.check(username, password)) {
//            return new ResponseEntity<>("Login Success", HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
//        }
//    }

    @PostMapping("/commonhelperlogin")
    public ResponseEntity<String> checkLogin(@RequestBody CommonHelper commonHelper)
    {
        if(loginService.check(commonHelper.getUsername(), commonHelper.getPassword())) {
           return new ResponseEntity<>("Login Success", HttpStatus.OK);
            //return loginService.getId(commonHelper.getUsername());
        }
        else{
            return new ResponseEntity<>("Login failed",HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/commonhelperfindId")
    public int findIdByName(@RequestBody CommonHelper commonHelper)
    {
        return loginService.getId(commonHelper.getUsername());
    }
}
