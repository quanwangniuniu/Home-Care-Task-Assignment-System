package com.example.haolongoldmansystem.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("commonhelper")
public class CommonHelper {
    @TableId("CommonHelperId")
    int CommonHelperId;
    @TableField("username")
    String username;
    @TableField("password")
    String password;
    @TableField("email")
    String email;

    public int getIdbyName(String name){
        return this.CommonHelperId;
    }


}
