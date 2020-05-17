package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 办事指南对象 business_guide
 * 
 * @author yu
 * @date 2020-04-15
 */
public class BusinessGuide extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Integer id;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private String isStart;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

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
    public void setIsStart(String isStart) 
    {
        this.isStart = isStart;
    }

    public String getIsStart() 
    {
        return isStart;
    }
    public void setCreateDate(Date createDate) 
    {
        this.createDate = createDate;
    }

    public Date getCreateDate() 
    {
        return createDate;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
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
            .append("isStart", getIsStart())
            .append("createDate", getCreateDate())
            .append("content", getContent())
            .append("remake", getRemake())
            .toString();
    }
}
