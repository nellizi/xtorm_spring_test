package com.example.test.loan;


import com.example.test.model.IntegratedEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepositoryCustom {


 List<IntegratedEntity> getIntegratedEntity();
}
