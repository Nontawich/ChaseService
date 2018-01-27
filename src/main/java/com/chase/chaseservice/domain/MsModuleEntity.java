package com.chase.chaseservice.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "ms_module")
public class MsModuleEntity {

    private Integer id;
    private String moduleCode;
    private Integer moduleSeq;
    private String moduleNameTh;
    private String moduleNameEn;
    private Integer moduleType;
    private String status;
    private String isActive;
    private Integer createBy;
    private Date createDate;
    private Integer updateBy;
    private Date updateDate;
    private String modulePath;
    private String moduleIcon;


    @Basic
    @Column(name = "module_name_th")
    public String getModuleNameTh() {
        return moduleNameTh;
    }

    public void setModuleNameTh(String moduleNameTh) {
        this.moduleNameTh = moduleNameTh;
    }

    @Basic
    @Column(name = "module_name_en")
    public String getModuleNameEn() {
        return moduleNameEn;
    }

    public void setModuleNameEn(String moduleNameEn) {
        this.moduleNameEn = moduleNameEn;
    }

    @Basic
    @Column(name = "module_icon")
    public String getModuleIcon() {
        return moduleIcon;
    }

    public void setModuleIcon(String moduleIcon) {
        this.moduleIcon = moduleIcon;
    }

    @Basic
    @Column(name = "module_path")
    public String getModulePath() {
        return modulePath;
    }

    public void setModulePath(String modulePath) {
        this.modulePath = modulePath;
    }

    @Id
    @Column(name = "module_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "module_code")
    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }


    @Basic
    @Column(name = "module_seq")
    public Integer getModuleSeq() {
        return moduleSeq;
    }

    public void setModuleSeq(Integer moduleSeq) {
        this.moduleSeq = moduleSeq;
    }

    @Basic
    @Column(name = "module_type")
    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "is_active")
    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "create_by")
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_by")
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "update_date")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MsModuleEntity that = (MsModuleEntity) o;
        if (id != that.id) return false;
        if (moduleCode != null ? !moduleCode.equals(that.moduleCode) : that.moduleCode != null) return false;
        if (moduleNameTh != null ? !moduleNameTh.equals(that.moduleNameTh) : that.moduleNameTh != null) return false;
        if (moduleNameEn != null ? !moduleNameEn.equals(that.moduleNameEn) : that.moduleNameEn != null) return false;
        if (moduleSeq != that.moduleSeq) return false;
        if (moduleType != that.moduleType) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
        if (createBy != that.createBy) return false;
        if (createDate != null ? createDate.compareTo(that.createDate) != 0 : that.createDate != null) return false;
        if (updateBy != that.updateBy) return false;
        if (updateDate != null ? updateDate.compareTo(that.updateDate) != 0 : that.updateDate != null) return false;
        if (moduleIcon != null ? !moduleIcon.equals(that.moduleIcon) : that.moduleIcon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = id;
        result = 31 * result + (moduleCode != null ? moduleCode.hashCode() : 0);
        result = 31 * result + (moduleNameTh != null ? moduleNameTh.hashCode() : 0);
        result = 31 * result + (moduleNameEn != null ? moduleNameEn.hashCode() : 0);
        result = 31 * result + (moduleSeq != null ? moduleSeq.hashCode() : 0);
        result = 31 * result + (moduleType != null ? moduleType.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (moduleIcon != null ? moduleIcon.hashCode() : 0);
        return result;
    }
}
