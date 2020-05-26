package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * VIEW对象 complaint_status
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public class ComplaintStatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long countsta;

    /** 投诉处理状态 0：未处理，1：已处理 */
    @Excel(name = "投诉处理状态 0：未处理，1：已处理")
    private String status;

    public void setCountsta(Long countsta) 
    {
        this.countsta = countsta;
    }

    public Long getCountsta() 
    {
        return countsta;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("countsta", getCountsta())
            .append("status", getStatus())
            .toString();
    }
}
