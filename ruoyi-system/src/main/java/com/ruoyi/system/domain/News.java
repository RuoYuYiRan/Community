package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 news
 * 
 * @author ruoyi
 * @date 2020-05-23
 */
public class News extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 上报人 */
    @Excel(name = "上报人")
    private String informer;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 信息 */
    @Excel(name = "信息")
    private String message;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInformer(String informer) 
    {
        this.informer = informer;
    }

    public String getInformer() 
    {
        return informer;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("informer", getInformer())
            .append("email", getEmail())
            .append("message", getMessage())
            .toString();
    }
}
