package com.example.test.loan;

import com.example.test.model.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity,Long>, LoanRepositoryCustom {


    LoanEntity findByImageKey(String imgKey);
}
