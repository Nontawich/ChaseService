package com.chase.chaseservice.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_candidate_job", catalog = "")
@Data
public class CandidateWorkEntity {
    @Id
    @Column(name = "candidate_job_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer jobId;

    @Basic
    @Column(name = "candidate_company_name")
    private String companyName;

    @Basic
    @Column(name = "job_type")
    private String jobType;

    @Basic
    @Column(name = "candidate_id")
    private Integer candidateId;

    @Basic
    @Column(name = "candidate_job_salary")
    private String salary;

    @Basic
    @Column(name = "candidate_job_start")
    private String jobStart;

    @Basic
    @Column(name = "candidate_job_end")
    private String jobEnd;

    @Basic
    @Column(name = "candidate_job_status")
    private String status;

    @Basic
    @Column(name = "candidate_job_create_date")
    private Date createDate;

    @Basic
    @Column(name = "candidate_job_update_date")
    private Date updateDate;

    public CandidateWorkEntity(String companyName, String jobType, Integer candidateId, String salary, String jobStart, String jobEnd, String status, Date createDate, Date updateDate) {
        this.companyName = companyName;
        this.jobType = jobType;
        this.candidateId = candidateId;
        this.salary = salary;
        this.jobStart = jobStart;
        this.jobEnd = jobEnd;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }


    public CandidateWorkEntity() {
    }
}
