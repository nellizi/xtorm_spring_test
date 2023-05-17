//package com.example.test.loan;
//
//import com.example.test.model.LoanEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LoanService {
//
//    @Autowired
//    LoanRepository loanRepository;
//
//    public void deleteExpiredTask(String imgKey) {
//        LoanEntity loanEntity = loanRepository.findByImageKey(imgKey);
//        loanEntity.setTask_size(loanEntity.getTask_size()-1);
//        loanRepository.save(loanEntity);
//
//        if(loanEntity.getTask_size() == 0){
//            loanEntity.setCheckDelete("Y");
//            loanRepository.save(loanEntity);
//        }
//    }
//}
