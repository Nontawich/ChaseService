package com.chase.chaseservice.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "registerlist")
@Data
public class RegisterListViewEntity {

    @Id
    @Column(name="candidate_id")
    private Integer candidateId;

    @Basic
    @Column(name="candidate_fullname")
    private String candidateFullName;

    @Basic
    @Column(name="age")
    private String age;

    @Basic
    @Column(name="register_date")
    private String registerDate;

    @Basic
    @Column(name="candidate_status")
    private String status;

    @Basic
    @Column(name="sexual")
    private String sexual;

    @Basic
    @Column(name="candidate_id_card")
    private String idCard;

    @Basic
    @Column(name="file_id")
    private String fileId;
}
