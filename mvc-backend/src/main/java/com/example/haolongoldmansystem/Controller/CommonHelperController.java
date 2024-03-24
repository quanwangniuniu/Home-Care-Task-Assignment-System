package com.example.haolongoldmansystem.Controller;

import com.example.haolongoldmansystem.Dao.FoodOrderDao;
import com.example.haolongoldmansystem.Entity.*;
import com.example.haolongoldmansystem.Service.CommonHelperService;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommonHelperController {
    @Autowired
    private CommonHelperService commonHelperService;
    @PostMapping("/getfoodorders")
    public FoodOrder updateFoodData(@RequestBody FoodOrder foodOrder){
        commonHelperService.update(foodOrder);
        return foodOrder;
    }
    @PostMapping("/getmedicineorders")
    public MedicineOrder updateMedicineData(@RequestBody MedicineOrder medicineOrder){
        //commonHelperService.insertmedicine(medicineOrder);
        commonHelperService.updatemedicine(medicineOrder);
        return medicineOrder;
    }
    @PostMapping("/getroomorders")
    public DeadRoomOrder updateRoomData(@RequestBody DeadRoomOrder deadRoomOrder){
        //commonHelperService.insertRoomorder(deadRoomOrder);
        commonHelperService.updateRoomorder(deadRoomOrder);
        return deadRoomOrder;
    }

    @GetMapping("/getallfoodorders")
    public List<FoodOrder> getorders(){
        return commonHelperService.getAllOrders();
    }

    @GetMapping("/getAllFoodOrdersById/{id}")
    public List<FoodOrder> getFoodOrdersById(@PathVariable int id)
    {
        return commonHelperService.findAllFoodordersById(id);
    }
    @GetMapping("/getallmedicineorders")
    public List<MedicineOrder>getmedicineorders(){
        return commonHelperService.getallmedicine();
    }

    @GetMapping("/getAllMedicineOrdersById/{id}")
    public List<MedicineOrder> getMedicineOrdersById(@PathVariable int id)
    {
        return commonHelperService.findAllMedicineordersById(id);
    }
    @GetMapping("/getallroomorders")
    public List<DeadRoomOrder>getroomorders(){
        return commonHelperService.getAllroomOrders();
    }

    @GetMapping("/getAllDeadRoomsOrdersById/{id}")
    public List<DeadRoomOrder> getDeadRoomsOrdersById(@PathVariable int id)
    {
        return commonHelperService.findAllDeadRoomordersById(id);
    }

    @PostMapping("/transport")
    public Driver findDriver(@RequestBody TransportData transportData)
    {
        return commonHelperService.transport(transportData);
    }

}
