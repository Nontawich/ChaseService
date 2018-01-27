package com.chase.chaseservice.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ts_file_manage", catalog = "")
@Data
public class ChaseDocument {
    public ChaseDocument() {
        super();
    }

    @Id
    @Column(name = "file_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long dmid;

    @Basic
    @Column(name = "file_name")
    private String filename;

    @Basic
    @Column(name = "file_version")
    private Integer version;

    @Basic
    @Column(name = "file_owner")
    private Integer owner;

    @Basic
    @Column(name = "create_by")
    private Integer createBy;

    @Basic
    @Column(name = "create_date")
    private Date createDate;

    @Basic
    @Column(name = "file_parent_id")
    private Long dmidparent;

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "update_date")
    private Date updatedate;

    @Basic
    @Column(name = "update_by")
    private Integer updateby;

    @Basic
    @Column(name = "file_status")
    private String status;

    @Basic
    @Column(name = "file_key")
    private byte[] key;


}
