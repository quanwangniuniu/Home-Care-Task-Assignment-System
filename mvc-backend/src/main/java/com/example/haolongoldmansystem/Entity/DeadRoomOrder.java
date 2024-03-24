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
@TableName("deadroomorder")
public class DeadRoomOrder {
    private String username;
    private Long phone;
    private String situation;
    private String note;
    @TableId(value="roomorder_id")
    private int orderId;
    @TableField("helper_id")
    private int helperId;
    @TableField("status")
    private int status; //  0 代表未被接单  1 代表订单进行中  2 代表订单已完成
}
