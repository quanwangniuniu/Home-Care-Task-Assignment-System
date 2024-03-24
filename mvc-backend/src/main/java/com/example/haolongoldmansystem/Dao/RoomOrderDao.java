package com.example.haolongoldmansystem.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.haolongoldmansystem.Entity.DeadRoomOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomOrderDao extends BaseMapper<DeadRoomOrder> {
}
