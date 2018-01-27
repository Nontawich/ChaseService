package com.chase.chaseservice.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_candidate_education", catalog = "")
@Data
public class CandidateEducationEntity {
    @Id
    @Column(name="candidate_education_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer candidateEducationId;

    @Basic
    @Column(name="education_id")
    private Integer educationId;

    @Basic
    @Column(name="candidate_education_faculty")
    private String candidateEducationFaculty;

    @Basic
    @Column(name="candidate_education_branch")
    private String candidateEducationBranch;

    @Basic
    @Column(name="candidate_education_institute")
    private String candidateEducationInstitute;

    @Basic
    @Column(name="candidate_id")
    private Integer candidateId;

    @Basic
    @Column(name="candidate_education_start")
    private String candidateEducationStart;

    @Basic
    @Column(name="candidate_education_end")
    private String candidateEducationEnd;

    @Basic
    @Column(name="status")
    private String status;

    @Basic
    @Column(name="candidate_education_gpa")
    private String candidateEducationGpa;

    public CandidateEducationEntity(Integer educationId, String candidateEducationFaculty, String candidateEducationBranch, String candidateEducationInstitute, Integer candidateId, String candidateEducationStart, String candidateEducationEnd, String status, String candidateEducationGpa) {
        this.educationId = educationId;
        this.candidateEducationFaculty = candidateEducationFaculty;
        this.candidateEducationBranch = candidateEducationBranch;
        this.candidateEducationInstitute = candidateEducationInstitute;
        this.candidateId = candidateId;
        this.candidateEducationStart = candidateEducationStart;
        this.candidateEducationEnd = candidateEducationEnd;
        this.status = status;
        this.candidateEducationGpa = candidateEducationGpa;
    }
}
