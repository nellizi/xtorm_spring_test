package com.example.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends PagingAndSortingRepository<BizEntity,String>, QueryByExampleExecutor<BizEntity> {


    String findByElementId(String elementId);
}
