package com.chase.chaseservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_candidate", catalog = "")
@Data
public class CandidateEntity {

    @Id
    @Column(name = "candidate_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer canId;

    @Basic
    @Column(name = "candidate_title_id")
    private Integer titleId;

    @Basic
    @Column(name = "candidate_name")
    private String candidateName;

    @Basic
    @Column(name = "candidate_surname")
    private String candidateSurName;

    @Basic
    @Column(name = "candidate_id_card")
    private String candidateIdCard;

    @Basic
    @Column(name = "candidate_birth_date")
    private Date candidateBirthDate;

    @Basic
    @Column(name = "candidate_address_no")
    private String candidateAddressNo;

    @Basic
    @Column(name = "candidate_address_district")
    private Integer candidateAddressDistrict;

    @Basic
    @Column(name = "candidate_address_sub_district")
    private Integer candidateAddressSubDistrict;

    @Basic
    @Column(name = "candidate_address_province")
    private Integer candidateAddressProvince;

    @Basic
    @Column(name = "candidate_postal_code")
    private String candidatePostalCode;

    @Basic
    @Column(name = "candidate_experince")
    private String candidateExperience;

    @Basic
    @Column(name = "candidate_expect_salary")
    private String candidateExpectSalary;

    @Basic
    @Column(name = "candidate_picture")
    private String candidatePicture;

    @Basic
    @Column(name = "candidate_register_date")
    private Date candidateRegisterDate;

    @Basic
    @Column(name = "candidate_update_date")
    private Date candidateUpdateDate;

    @Basic
    @Column(name = "candidate_status")
    private String candidateStatus;

    @Basic
    @Column(name = "candidate_email")
    private String candidateEmail;

    @Basic
    @Column(name = "candidate_phone")
    private String candidatePhone;

    @Basic
    @Column(name = "candidate_mobile")
    private String candidateMobile;

    @Basic
    @Column(name = "available_id")
    private Integer availableId;

    @Basic
    @Column(name = "candidate_sexual")
    private Integer sexual;

    public CandidateEntity(Integer titleId, String candidateName, String candidateSurName, String candidateIdCard, Date candidateBirthDate, String candidateAddressNo, Integer candidateAddressDistrict, Integer candidateAddressSubDistrict, Integer candidateAddressProvince, String candidatePostalCode, String candidateExperience, String candidateExpectSalary, String candidatePicture, Date candidateRegisterDate, Date candidateUpdateDate, String candidateStatus, String candidateEmail, String candidatePhone, String candidateMobile, Integer availableId, Integer sexual) {
        this.titleId = titleId;
        this.candidateName = candidateName;
        this.candidateSurName = candidateSurName;
        this.candidateIdCard = candidateIdCard;
        this.candidateBirthDate = candidateBirthDate;
        this.candidateAddressNo = candidateAddressNo;
        this.candidateAddressDistrict = candidateAddressDistrict;
        this.candidateAddressSubDistrict = candidateAddressSubDistrict;
        this.candidateAddressProvince = candidateAddressProvince;
        this.candidatePostalCode = candidatePostalCode;
        this.candidateExperience = candidateExperience;
        this.candidateExpectSalary = candidateExpectSalary;
        this.candidatePicture = candidatePicture;
        this.candidateRegisterDate = candidateRegisterDate;
        this.candidateUpdateDate = candidateUpdateDate;
        this.candidateStatus = candidateStatus;
        this.candidateEmail = candidateEmail;
        this.candidatePhone = candidatePhone;
        this.candidateMobile = candidateMobile;
        this.availableId = availableId;
        this.sexual = sexual;
    }

    public CandidateEntity() {
    }
}
