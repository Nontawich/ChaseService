package com.chase.chaseservice.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ms_sexual")
@Data
public class MsSexualEntity {

    @Id
    @Column(name="sexual_id")
    private Integer sexualId;

    @Basic
    @Column(name="sexual_name_th")
    private String sexualNameTh;

    @Basic
    @Column(name="sexual_name_en")
    private String sexualNameEn;

    @Basic
    @Column(name="sexual_status")
    private String status;
}
