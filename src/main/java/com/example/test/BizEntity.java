package com.example.test;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "businesscontent")
public class BizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ELEMENTID")
    @Setter
    private String elementId;

    @Column(name = "IMG_KEY")
    private String IMG_KEY;

    @Column(name = "DOC_CD")
    private String DOC_CD;

    @Column(name = "SEQ_NO")
    private Integer SEQ_NO;

    @Column(name = "CUST_NO")
    private String CUST_NO;

    @Column(name = "CUST_NM")
    private String CUST_NM;

    @Column(name = "RRN_NO")
    private String RRN_NO;

    @Column(name = "FILE_NM")
    private String FILE_NM;

    @Column(name = "ENR_USER_ID")
    private String ENR_USER_ID;

    @Column(name = "ENR_ORG_CD")
    private String ENR_ORG_CD;

    @CreationTimestamp
    @Column(name = "ENR_DTM")
    private LocalDateTime ENR_DTM;



//    public static PostEntity toEntity(PostDto dto) {
//        PostEntity entity = PostEntity.builder()
//                .postId(dto.getPostId())
//                .postCid(dto.getPostCid())
//                .user(dto.getUser())
//                .checked(false)
//                .title(dto.getTitle())
//                .body(dto.getBody())
//                .likes(dto.getLikes())
//                .createdAt(dto.getCreatedAt())
//                .updatedAt(dto.getUpdatedAt())
//                .build();
//        return entity;
//    }

}
