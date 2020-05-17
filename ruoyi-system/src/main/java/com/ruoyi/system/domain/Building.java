package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 楼宇管理对象 building
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
public class Building extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Integer id;

    /** 小区id */
    @Excel(name = "小区id")
    private Integer cellId;

    /** 楼宇名称 */
    @Excel(name = "楼宇名称")
    private String buildName;

    /** 单元数量 */
    @Excel(name = "单元数量")
    private Integer cellNum;

    /** 楼宇层次 */
    @Excel(name = "楼宇层次")
    private String buildLevel;

    /** 楼宇类型 */
    @Excel(name = "楼宇类型")
    private String buildType;

    /** 楼宇结构 */
    @Excel(name = "楼宇结构")
    private String buildStructure;

    /** 楼宇朝向 */
    @Excel(name = "楼宇朝向")
    private String buildOrientation;

    /** 备注 */
    @Excel(name = "备注")
    private String remake;

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

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Integer getCellNum() {
        return cellNum;
    }

    public void setCellNum(Integer cellNum) {
        this.cellNum = cellNum;
    }

    public String getBuildLevel() {
        return buildLevel;
    }

    public void setBuildLevel(String buildLevel) {
        this.buildLevel = buildLevel;
    }

    public void setBuildType(String buildType)
    {
        this.buildType = buildType;
    }

    public String getBuildType() 
    {
        return buildType;
    }
    public void setBuildStructure(String buildStructure) 
    {
        this.buildStructure = buildStructure;
    }

    public String getBuildStructure() 
    {
        return buildStructure;
    }
    public void setBuildOrientation(String buildOrientation) 
    {
        this.buildOrientation = buildOrientation;
    }

    public String getBuildOrientation() 
    {
        return buildOrientation;
    }
    public void setRemake(String remake) 
    {
        this.remake = remake;
    }

    public String getRemake() 
    {
        return remake;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cellId", getCellId())
            .append("buildName", getBuildName())
            .append("cellNum", getCellNum())
            .append("buildLevel", getBuildLevel())
            .append("buildType", getBuildType())
            .append("buildStructure", getBuildStructure())
            .append("buildOrientation", getBuildOrientation())
            .append("remake", getRemake())
            .toString();
    }
}
