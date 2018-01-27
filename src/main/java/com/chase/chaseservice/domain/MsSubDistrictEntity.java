package com.chase.chaseservice.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ms_sub_district")
@Data
public class MsSubDistrictEntity {

    @Id
    @Column(name="sub_district_id")
    private Integer subDistrictId;

    @Basic
    @Column(name="sub_district_code")
    private String subDistrictCode;

    @Basic
    @Column(name="sub_district_name")
    private String subDistrictName;

    @Basic
    @Column(name="district_id")
    private Integer districtId;

    @Basic
    @Column(name="province_id")
    private Integer provinceId;

    @Basic
    @Column(name="geo_id")
    private Integer geoId;

    @Basic
    @Column(name="create_date")
    private Date createDate;

    @Basic
    @Column(name="status")
    private String status;
}
