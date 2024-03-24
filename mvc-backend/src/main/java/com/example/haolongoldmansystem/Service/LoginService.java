package com.example.haolongoldmansystem.Service;

import com.example.haolongoldmansystem.Dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {
    @Autowired
    LoginDao loginDao;
    public boolean check(String username,String password){
        return Objects.equals(loginDao.getPasswordByuserName(username), password);
    }
    public int getId(String name)
    {
        return loginDao.getIdByuserName(name);
    }
}
