package com.chase.chaseservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ms_province")
@Data
public class MsProvinceEntity {

    @Id
    @Column(name = "province_id")
    private Integer provinceId;

    @Basic
    @Column(name = "province_name")
    private String provinceName;

    @Basic
    @Column(name = "province_code")
    private String provinceCode;

    @Basic
    @Column(name = "geo_id")
    private Integer geoId;

    @Basic
    @Column(name = "create_date")
    private Date createDate;

    @Basic
    @Column(name = "status")
    private String status;
}
