package com.example.haolongoldmansystem.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haolongoldmansystem.Entity.CommonHelper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginDao extends BaseMapper<CommonHelper> {
    @Select("SELECT CommonHelperId from commonhelper where username=#{username}")
    int getIdByuserName(@Param("username")String username);

    @Select("SELECT password from commonhelper where username=#{username}")
    String getPasswordByuserName(@Param("username")String username);
}
