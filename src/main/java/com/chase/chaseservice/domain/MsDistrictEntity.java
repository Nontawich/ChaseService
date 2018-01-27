package com.chase.chaseservice.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ms_district")
@Data
public class MsDistrictEntity {
    public MsDistrictEntity() {
        super();
    }

    @Id
    @Column(name = "district_id")
    private Integer districtId;

    @Basic
    @Column(name = "district_code")
    private String districtCode;

    @Basic
    @Column(name = "district_name")
    private String districtName;

    @Basic
    @Column(name = "postcode")
    private String postCode;

    @Basic
    @Column(name = "geo_id")
    private Integer geoId;

    @Basic
    @Column(name = "province_id")
    private Integer provinceId;

    @Basic
    @Column(name = "create_date")
    private Date createDate;

    @Basic
    @Column(name = "status")
    private String status;
}
