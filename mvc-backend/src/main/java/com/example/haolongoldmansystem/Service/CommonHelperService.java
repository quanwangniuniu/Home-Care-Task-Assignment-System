package com.example.haolongoldmansystem.Service;

import com.example.haolongoldmansystem.Dao.FoodOrderDao;
import com.example.haolongoldmansystem.Dao.MedicineOrderDao;
import com.example.haolongoldmansystem.Dao.RoomOrderDao;
import com.example.haolongoldmansystem.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class CommonHelperService {
    @Autowired
    private MedicineOrderDao medicineOrderDao;
    public MedicineOrder selectmedicineById(int id){
        return medicineOrderDao.selectById(id);
    }
    public boolean insertmedicine(MedicineOrder medicineOrder){
        return medicineOrderDao.insert(medicineOrder)>0;
    }
    public boolean deletemedicineById(int id){
        return medicineOrderDao.deleteById(id)>0;
    }
    public List<MedicineOrder> getallmedicine(){
        return medicineOrderDao.selectList(null);
    }

    public boolean updatemedicine(MedicineOrder medicineOrder){
        return medicineOrderDao.updateById(medicineOrder)>0;
    }
    public List<MedicineOrder> findAllMedicineordersById(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("helper_id",id);
        return medicineOrderDao.selectByMap(map);
    }

    @Autowired
    private FoodOrderDao foodOrderDao;
    public FoodOrder selectById(int id)
    {
        return foodOrderDao.selectById(id);
    }
    public boolean insert(FoodOrder foodOrder)
    {
        return foodOrderDao.insert(foodOrder)>0;
    }

    public boolean deleteById(int id)
    {
        return foodOrderDao.deleteById(id)>0;
    }

    public boolean update(FoodOrder foodOrder)
    {
        return foodOrderDao.updateById(foodOrder)>0;
    }

    public List<FoodOrder> getAllOrders()
    {
        return foodOrderDao.selectList(null);
    }

    public List<FoodOrder> findAllFoodordersById(int id){
        Map<String, Object> map = new HashMap<>();
        map.put("helper_id",id);
        return foodOrderDao.selectByMap(map);
    }

    @Autowired
    private RoomOrderDao roomOrderDao;
    public List<DeadRoomOrder> getAllroomOrders(){
        return roomOrderDao.selectList(null);
    }

    public boolean updateRoomorder(DeadRoomOrder deadRoomOrder){

        return roomOrderDao.updateById(deadRoomOrder)>0;
    }

    public boolean deleteRoomorderById(int id){
        return roomOrderDao.deleteById(id)>0;
    }

    public DeadRoomOrder selectRoomorderById(int id)
    {
        return roomOrderDao.selectById(id);
    }

    public boolean insertRoomorder(DeadRoomOrder deadRoomOrder)
    {
        return roomOrderDao.insert(deadRoomOrder)>0;
    }

    public List<DeadRoomOrder> findAllDeadRoomordersById(int id) {
        Map<String, Object> map = new HashMap<>();
        map.put("helper_id",id);
        return roomOrderDao.selectByMap(map);
    }

    public Driver transport(TransportData transportData) {
        Driver driver1 = new Driver("胡元发师傅","13019283716",6,30);
        Driver driver2 = new Driver("胡园发师傅","19019283726",8,32);
        Driver driver3 = new Driver("胡原发师傅","15019283736",21,34);
        Driver driver4 = new Driver("胡圆发师傅","13019383716",34,31);
        if(Objects.equals(transportData.getName(), "张三"))
        {
            return driver1;
        }
        else if(Objects.equals(transportData.getName(), "李四"))
        {
            return driver2;
        }
        else if(Objects.equals(transportData.getName(), "王五"))
        {
            return driver3;
        }
        return driver4;
    }
}
