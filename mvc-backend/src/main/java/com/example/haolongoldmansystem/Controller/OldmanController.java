package com.example.haolongoldmansystem.Controller;
import com.example.haolongoldmansystem.Entity.DeadRoomOrder;
import com.example.haolongoldmansystem.Entity.FoodOrder;
import com.example.haolongoldmansystem.Entity.MedicineOrder;
import com.example.haolongoldmansystem.Service.OldmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OldmanController {
    @Autowired
    OldmanService oldmanService;
    @PostMapping ("/foodorders")
    public void putfoodorder (@RequestBody FoodOrder foodOrder){
        oldmanService.putfoodorder(foodOrder);
    }

    @PostMapping("/medicineorders")
    public MedicineOrder putmedicineorder(@RequestBody MedicineOrder medicineOrder)
    {
        System.out.println(medicineOrder);
        oldmanService.putmedicineorder(medicineOrder);
        return medicineOrder;
    }

    @PostMapping("/deadroomorders")
    public DeadRoomOrder putdeadroomorder(@RequestBody DeadRoomOrder deadRoomOrder){
        System.out.println(deadRoomOrder);
        oldmanService.putdeadroomorder(deadRoomOrder);
        return deadRoomOrder;
    }
}
