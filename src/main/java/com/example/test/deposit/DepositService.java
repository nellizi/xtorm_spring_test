//package com.example.test.deposit;
//
//import com.example.test.model.DepositEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DepositService {
//
//    @Autowired
//    DepositRepository depositRepository;
//    public void deleteExpiredTask(String imgKey) {
//        DepositEntity commonEntity = depositRepository.findByImageKey(imgKey);
//        commonEntity.setTask_size(commonEntity.getTask_size()-1);
//        depositRepository.save(commonEntity);
//
//        if(commonEntity.getTask_size() == 0){
//            commonEntity.setCheckDelete("Y");
//            depositRepository.save(commonEntity);
//        }
//    }
//}
