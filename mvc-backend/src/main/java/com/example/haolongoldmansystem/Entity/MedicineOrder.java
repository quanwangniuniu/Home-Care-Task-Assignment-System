package com.example.haolongoldmansystem.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("medicineorder")
public class MedicineOrder {
    private String username;
    private Long phone;
    private String address;
    private String itemName;
    @TableId(value="medicine_orderid")
    private int orderId;
    @TableField("helper_id")
    private int helperId;
    @TableField("status")
    private int status;
}
