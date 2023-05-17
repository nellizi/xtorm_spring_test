package com.example.test.common;


import com.example.test.model.IntegratedEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonRepositoryCustom {


 List<IntegratedEntity> getIntegratedEntity();
}
