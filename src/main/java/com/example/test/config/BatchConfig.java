package com.example.test.config;//package com.inzent.batch.document.config;
//
//import com.inzent.batch.document.integrated.IntegratedRepository;
//import com.inzent.batch.document.integrated.IntegratedService;
//import com.inzent.batch.document.model.IntegratedEntity;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.repeat.RepeatStatus;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Slf4j
//@Configuration
//@EnableBatchProcessing
//public class BatchConfig {
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private IntegratedRepository integratedRepository;
//
//    @Autowired
//    private IntegratedService integratedService;
//
//    @Bean
//    public Job job() {
//
//        Job job = jobBuilderFactory.get("job")
//                .start(step())
//                .build();
//
//        return job;
//    }
//
//    @Bean
//    public Step step() {
//        return stepBuilderFactory.get("step")
//                .tasklet((contribution, chunkContext) -> {
//                    log.info("Step!");
//                    // 업데이트 시각이 일주일 이전인 문서 목록을 가져옴
//                    // 1. 네이티브 쿼리 사용
//                    List<IntegratedEntity> integratedEnities = integratedRepository.getIntegratedEntity();
//                    // 2. JPQL 사용
//                    // LocalDateTime now = LocalDateTime.now();
//                    // LocalDateTime aWeekAgo = now.minusDays(7);
//                    // List<Document> limitedDocuments = documentRepository.findByUpdateAtLessThan(aWeekAgo)
//
//                    if (integratedEnities.size() > 0 && integratedEnities != null) {
//                        for (IntegratedEntity integratedEntity : integratedEnities) {
//                            // deleteDocument는 document_id를 받아 서버와 db에서 문서 삭제를 구현하는 서비스
//                            integratedService.deleteCommonEntity(integratedEntity.getImageKey());
//                        }
//                    }
//                    return RepeatStatus.FINISHED;
//                })
//                .build();
//    }
//}