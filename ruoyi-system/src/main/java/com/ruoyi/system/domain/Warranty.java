package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 保修对象 warranty
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
public class Warranty extends BaseEntity
{
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

    /** 保修描述 */
    @Excel(name = "保修描述")
    private String warrantyInstructions;

    /** 备注 */
    @Excel(name = "备注")
    private String remake;

    /** 保修状态 */
    @Excel(name = "保修状态")
    private String status;

    /** 结束日期 */
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    private ResidentialQuarters residentialQuarters;

    private Building building;

    private House house;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setCellId(Integer cellId) 
    {
        this.cellId = cellId;
    }

    public Integer getCellId() 
    {
        return cellId;
    }
    public void setBuildId(Integer buildId) 
    {
        this.buildId = buildId;
    }

    public Integer getBuildId() 
    {
        return buildId;
    }
    public void setHouseId(Integer houseId) 
    {
        this.houseId = houseId;
    }

    public Integer getHouseId() 
    {
        return houseId;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setTellPhone(String tellPhone) 
    {
        this.tellPhone = tellPhone;
    }

    public String getTellPhone() 
    {
        return tellPhone;
    }
    public void setWarrantyInstructions(String warrantyInstructions) 
    {
        this.warrantyInstructions = warrantyInstructions;
    }

    public String getWarrantyInstructions() 
    {
        return warrantyInstructions;
    }
    public void setRemake(String remake) 
    {
        this.remake = remake;
    }

    public String getRemake() 
    {
        return remake;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
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
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cellId", getCellId())
            .append("buildId", getBuildId())
            .append("houseId", getHouseId())
            .append("address", getAddress())
            .append("tellPhone", getTellPhone())
            .append("warrantyInstructions", getWarrantyInstructions())
            .append("remake", getRemake())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
