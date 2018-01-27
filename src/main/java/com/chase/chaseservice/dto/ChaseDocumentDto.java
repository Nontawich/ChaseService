package com.chase.chaseservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ChaseDocumentDto {

    private String dmid;
    private String filename;
    private String version;
    private String owner;
    private String dmidparent;
    private String status;
    private String memo;
    private String fileStatus;
    private String createBy;
    private String createDate;
    private String fileMode;
    private String updatedate;
    private String updateby;
    private String fileTypeId;

    public ChaseDocumentDto() {
        super();
    }


    public ChaseDocumentDto(Long dmid, String filename, Integer version, String owner, Long dmidparent, String status , String memo, String fileStatus
            , String createBy , Date createDate , String fileMode , Date updatedate , String updateby , Long fileTypeId) {
        this.dmid = String.valueOf(dmid);
        this.filename = filename;
        this.version =  String.valueOf(version);
        this.owner = owner ;
        this.dmidparent = String.valueOf(dmidparent);
        this.status = status;
        this.memo = memo;
        this.fileStatus = fileStatus;
        this.createBy = createBy;
        this.createDate = String.valueOf(createDate) ;
        this.fileMode = fileMode;
        this.updatedate = String.valueOf(updatedate);
        this.updateby =updateby;
        this.fileTypeId= fileTypeId == 3 ? "สินค้านำเข้า" : fileTypeId== 4 ? "สินค้าส่งออก" : "-";
    }
}
