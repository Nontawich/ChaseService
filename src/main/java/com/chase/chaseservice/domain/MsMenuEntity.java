package com.chase.chaseservice.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ms_menu")
public class MsMenuEntity {

    private Integer id;
    private String menuCode;
    private String menuNameEn;
    private String menuNameTh;
    private Integer menuSeq;
    private String status;
    private String isActive;
    private Integer createBy;
    private Date createDate;
    private Integer updateBy;
    private Date updateDate;
    private Integer module;
    private String menuPath;

    @Basic
    @Column(name = "menu_name_en")
    public String getMenuNameEn() {
        return menuNameEn;
    }

    public void setMenuNameEn(String menuNameEn) {
        this.menuNameEn = menuNameEn;
    }

    @Basic
    @Column(name = "menu_name_th")
    public String getMenuNameTh() {
        return menuNameTh;
    }

    public void setMenuNameTh(String menuNameTh) {
        this.menuNameTh = menuNameTh;
    }

    @Basic
    @Column(name = "menu_path")
    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public Integer getModule() {
        return module;
    }

    @Basic
    @Column(name = "module_id")
    public void setModule(Integer module) {
        this.module = module;
    }

    @Id
    @Column(name = "menu_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "menu_code")
    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    @Basic
    @Column(name = "menu_seq")
    public Integer getMenuSeq() {
        return menuSeq;
    }

    public void setMenuSeq(Integer menuSeq) {
        this.menuSeq = menuSeq;
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
    @Column(name = "update_date")
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "update_by")
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

        MsMenuEntity that = (MsMenuEntity) o;
        if (id != that.id) return false;
        if (menuCode != null ? !menuCode.equals(that.menuCode) : that.menuCode != null) return false;
        if (menuNameTh != null ? !menuNameTh.equals(that.menuNameTh) : that.menuNameTh != null) return false;
        if (menuNameEn != null ? !menuNameEn.equals(that.menuNameEn) : that.menuNameEn != null) return false;
        if (menuSeq != that.menuSeq) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
        if (createBy != that.createBy) return false;
        if (createDate != null ? createDate.compareTo(that.createDate) != 0 : that.createDate != null) return false;
        if (updateBy != that.updateBy) return false;
        if (updateDate != null ? updateDate.compareTo(that.updateDate) != 0 : that.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = id;
        result = 31 * result + (menuCode != null ? menuCode.hashCode() : 0);
        result = 31 * result + (menuNameTh != null ? menuNameTh.hashCode() : 0);
        result = 31 * result + (menuNameEn != null ? menuNameEn.hashCode() : 0);
        result = 31 * result + (menuSeq != null ? menuSeq.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        result = 31 * result + (createBy != null ? createBy.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateBy != null ? updateBy.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }
}
