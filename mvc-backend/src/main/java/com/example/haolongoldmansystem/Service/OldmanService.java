package com.example.haolongoldmansystem.Service;

import com.example.haolongoldmansystem.Dao.FoodOrderDao;
import com.example.haolongoldmansystem.Dao.MedicineOrderDao;
import com.example.haolongoldmansystem.Dao.RoomOrderDao;
import com.example.haolongoldmansystem.Entity.DeadRoomOrder;
import com.example.haolongoldmansystem.Entity.FoodOrder;
import com.example.haolongoldmansystem.Entity.MedicineOrder;
import com.example.haolongoldmansystem.Entity.OldPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OldmanService {
    @Autowired
    FoodOrderDao foodOrderDao;
    @Autowired
    MedicineOrderDao medicineOrderDao;
    @Autowired
    RoomOrderDao roomOrderDao;
    public void putfoodorder(FoodOrder foodOrder)
    {
        foodOrderDao.insert(foodOrder);
    }

    public void putmedicineorder(MedicineOrder medicineOrder)
    {
        medicineOrderDao.insert(medicineOrder);
    }

    public void putdeadroomorder(DeadRoomOrder deadRoomOrder)
    {
        roomOrderDao.insert(deadRoomOrder);
    }
}
