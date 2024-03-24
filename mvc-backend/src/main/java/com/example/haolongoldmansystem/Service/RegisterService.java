package com.example.haolongoldmansystem.Service;

import com.example.haolongoldmansystem.Dao.RegisterDao;
import com.example.haolongoldmansystem.Entity.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    RegisterDao registerDao;
    public void register(CommonHelper commonHelper){
        registerDao.insert(commonHelper);
    }

    public void checkDuplicate()
    {
        //registerDao.selectByMap();
    }
}
