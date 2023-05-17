package com.example.test.deposit;


import com.example.test.model.IntegratedEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepositoryCustom {


 List<IntegratedEntity> getIntegratedEntity();
}
