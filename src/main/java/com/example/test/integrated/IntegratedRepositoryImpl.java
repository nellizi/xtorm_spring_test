package com.example.test.integrated;


import com.example.test.model.IntegratedEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.test.model.QIntegratedEntity.integratedEntity;

@RequiredArgsConstructor
public class IntegratedRepositoryImpl implements IntegratedRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;



    @Override
    public List<IntegratedEntity> getIntegratedEntity() {
//        LocalDateTime toDay = LocalDateTime.now();
//        Date nowDate = java.sql.Timestamp.valueOf(toDay);
        List<IntegratedEntity> integratedEnities = jpaQueryFactory
                .selectFrom(integratedEntity)
//                .where(integratedEntity.deleteDate.after(LocalDateTime.now()))
                .fetch();

        return integratedEnities;
    }

    @Override
    public List<IntegratedEntity> findByCheckDelete() {
        List<IntegratedEntity> integratedEnities = jpaQueryFactory
                .selectFrom(integratedEntity)
                .where(integratedEntity.checkDelete.eq("N"))
                .fetch();

        return integratedEnities;
    }



}
