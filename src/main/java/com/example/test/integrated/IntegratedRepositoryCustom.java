package com.example.test.integrated;


import com.example.test.model.IntegratedEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntegratedRepositoryCustom {

    List<IntegratedEntity> getIntegratedEntity();

    List<IntegratedEntity> findByCheckDelete();

}
