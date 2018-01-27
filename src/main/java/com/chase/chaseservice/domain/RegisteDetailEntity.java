package com.chase.chaseservice.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "registerdetaillist")
@Data
public class RegisteDetailEntity {
    @Id
    @Column(name="candidate_id")
    private Integer candidateId;

    @Basic
    @Column(name="candidate_fullname")
    private String candidateFullname;

    @Basic
    @Column(name="age")
    private String age;

    @Basic
    @Column(name="register_date")
    private String registeDate;

    @Basic
    @Column(name="candidate_birth_date")
    private String birthDate;

    @Basic
    @Column(name="candidate_status")
    private String status;

    @Basic
    @Column(name="sexual")
    private String sexual;

    @Basic
    @Column(name="candidate_id_card")
    private String candidateIdCard;

    @Basic
    @Column(name="file_id")
    private String fileId;

    @Basic
    @Column(name="candidate_email")
    private String email;

    @Basic
    @Column(name="candidate_phone")
    private String phone;

    @Basic
    @Column(name="candidate_picture")
    private String picture;

    @Basic
    @Column(name="candidate_mobile")
    private String mobile;

    @Basic
    @Column(name="candidate_experince")
    private String exp;

    @Basic
    @Column(name="candidate_expect_salary")
    private String expSalary;

    @Basic
    @Column(name="candidate_address_no")
    private String addressNo;

    @Basic
    @Column(name="province_name")
    private String provinceName;

    @Basic
    @Column(name="district_name")
    private String districtName;

    @Basic
    @Column(name="sub_district_name")
    private String subDistrictName;

    @Basic
    @Column(name="candidate_postal_code")
    private String postalCode;

    @Basic
    @Column(name="candidate_education_institute")
    private String institute;

    @Basic
    @Column(name="yearedu")
    private String yearEdu;

    @Basic
    @Column(name="candidate_education_faculty")
    private String faculty;

    @Basic
    @Column(name="candidate_education_branch")
    private String branch;

    @Basic
    @Column(name="candidate_education_gpa")
    private String gpa;
}
