package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区管理对象 residential_quarters
 * 
 * @author yu
 * @date 2020-04-15
 */
public class ResidentialQuarters extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Integer id;

    /** 小区编号 */
    @Excel(name = "小区编号")
    private String cellName;

    /** 小区地址 */
    @Excel(name = "小区地址")
    private String cellAddress;

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
    public void setCellName(String cellName) 
    {
        this.cellName = cellName;
    }

    public String getCellName() 
    {
        return cellName;
    }
    public void setCellAddress(String cellAddress) 
    {
        this.cellAddress = cellAddress;
    }

    public String getCellAddress() 
    {
        return cellAddress;
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
            .append("cellName", getCellName())
            .append("cellAddress", getCellAddress())
            .append("remake", getRemake())
            .toString();
    }
}
