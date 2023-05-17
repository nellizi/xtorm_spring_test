//package com.example.test.common;
//
//import com.example.test.model.CommonEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CommonService {
//    @Autowired
//    CommonRepository commonRepository;
//
//    public void deleteExpiredTask(String imgKey) {
//        CommonEntity commonEntity = commonRepository.findByImageKey(imgKey);
//        commonEntity.setTask_size(commonEntity.getTask_size()-1);
//        commonRepository.save(commonEntity);
//
//        if(commonEntity.getTask_size() == 0){
//            commonEntity.setCheckDelete("Y");
//            commonRepository.save(commonEntity);
//        }
//    }
//}
