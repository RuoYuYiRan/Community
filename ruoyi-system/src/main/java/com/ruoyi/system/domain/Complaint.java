package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 投诉对象 complaint
 * @date 2020-4/21
 */
public class Complaint extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** null */
    private Integer id;

    /** 小区id */
    @Excel(name = "小区id")
    private Integer cellId;

    /** 楼宇id */
    @Excel(name = "楼宇id")
    private Integer buildId;

    /** 房屋id */
    @Excel(name = "房屋id")
    private Integer houseId;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String tellPhone;

    /** 投诉内容 */
    @Excel(name = "投诉内容")
    private String complaintInstructions;

    /** 备注 */
    @Excel(name = "备注")
    private String remake;

    /** 投诉处理状态 */
    @Excel(name = "处理状态")
    private String status;

    /** 上报时间 */
    @Excel(name = "上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;

    /** 处理时间 */
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 反馈 */
    @Excel(name = "反馈")
    private String feedback;

    private ResidentialQuarters residentialQuarters;

    private Building building;

    private House house;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCellId() {
        return cellId;
    }

    public void setCellId(Integer cellId) {
        this.cellId = cellId;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTellPhone() {
        return tellPhone;
    }

    public void setTellPhone(String tellPhone) {
        this.tellPhone = tellPhone;
    }

    public String getComplaintInstructions() {
        return complaintInstructions;
    }

    public void setComplaintInstructions(String complaintInstructions) {
        this.complaintInstructions = complaintInstructions;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public ResidentialQuarters getResidentialQuarters() {
        return residentialQuarters;
    }

    public void setResidentialQuarters(ResidentialQuarters residentialQuarters) {
        this.residentialQuarters = residentialQuarters;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("cellId", getCellId())
                .append("buildId", getBuildId())
                .append("houseId", getHouseId())
                .append("address", getAddress())
                .append("tellPhone", getTellPhone())
                .append("complaintInstructions", getComplaintInstructions())
                .append("remake", getRemake())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("endTime", getEndTime())
                .append("feedback", getFeedback())
                .toString();
    }

}
