package com.example.test.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "INTEGRATED_TASK")
public class IntegratedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long integratedId;

    @Column(name = "IMG_KEY")
    @Setter
    private String imageKey;


    @Column(name = "ELEMENTID")
    @Setter
    private String elementId;

    @Column(name = "SEQ_NO")
    @Setter
    private String seqNo;


    @Column(name = "DOC_CD")
    @Setter
    private String documentCd;

    @Setter
    @Column(name = "DEL_DATE")
    private LocalDateTime deleteDate;

    @Column(name = "TASK_CD")
    @Setter
    private String taskCode;

    @Column(name = "FILE_NM")
    @Setter
    private String fileName;

    @Column(name = "EXTENTION")
    @Setter
    private String extention;


    @Setter
    @Column(name = "REGDATE")
    private Date regDate;

    @Column(name = "CREATE_USR")
    @Setter
    private String createUser;

    @Setter
    @Column(name = "UPDATE_AT")
    private Date updateAt;

    @Column(name = "UPDATE_USR")
    @Setter
    private String updateUser;


    @Column(name = "DEL_YN")
    @Setter
    private String checkDelete;


}
