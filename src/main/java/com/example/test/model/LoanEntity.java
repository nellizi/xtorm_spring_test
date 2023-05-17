package com.example.test.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "LOAN_TASK")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long loanId;

    @Column(name = "IMG_KEY")
    @Setter
    private String imageKey;

    @Column(name = "CUST_NO")
    @Setter
    private String custNumber;

    @Column(name = "CUST_NM")
    @Setter
    private String custName;

    @Column(name = "RRN_NO")
    @Setter
    private String rrgNumber;

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

    @Column(name = "TASK_SIZE")
    @Setter
    private int task_size;

}
