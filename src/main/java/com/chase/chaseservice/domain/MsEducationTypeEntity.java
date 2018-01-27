package com.chase.chaseservice.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ms_education_type")
@Data
public class MsEducationTypeEntity {

    @Id
    @Column(name="education_id")
    private Integer educationId;

    @Basic
    @Column(name="education_type_name_th")
    private String educationNameTh;

    @Basic
    @Column(name="education_type_name_en")
    private String educationNameEn;

    @Basic
    @Column(name="status")
    private String status;

    @Basic
    @Column(name="seq")
    private Integer seq;
}
