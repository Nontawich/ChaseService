package com.chase.chaseservice.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ms_title")
@Data
public class MsTitleEntity {

    @Id
    @Column(name = "title_id")
    private Integer titleId;

    @Basic
    @Column(name = "title_name_th")
    private String titleNameTh;

    @Basic
    @Column(name = "title_name_en")
    private String titleNameEn;

    @Basic
    @Column(name = "title_status")
    private String status;
}
