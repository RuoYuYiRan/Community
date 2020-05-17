package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆管理对象 vehicle
 * 
 * @author yu
 * @date 2020-04-15
 */
public class Vehicle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Integer id;

    /** 小区编号 */
    @Excel(name = "小区编号")
    private Integer cellId;

    /** 车辆编号 */
    @Excel(name = "车辆编号")
    private Integer vehicleNum;

    /** 车位号 */
    @Excel(name = "车位号")
    private String parkingNum;

    /** 停车卡号 */
    @Excel(name = "停车卡号")
    private String parkingCardNum;

    /** 车主姓名 */
    @Excel(name = "车主姓名")
    private String vehicleOwner;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String tellPhone;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNum;

    /** 排量 */
    @Excel(name = "排量")
    private String vehicleDisplacement;

    /** 用户编号 */
    @Excel(name = "用户编号")
    private Integer userId;

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
    public void setVehicleNum(Integer vehicleNum) 
    {
        this.vehicleNum = vehicleNum;
    }

    public Integer getVehicleNum() 
    {
        return vehicleNum;
    }
    public void setParkingNum(String parkingNum) 
    {
        this.parkingNum = parkingNum;
    }

    public String getParkingNum() 
    {
        return parkingNum;
    }
    public void setParkingCardNum(String parkingCardNum) 
    {
        this.parkingCardNum = parkingCardNum;
    }

    public String getParkingCardNum() 
    {
        return parkingCardNum;
    }
    public void setVehicleOwner(String vehicleOwner) 
    {
        this.vehicleOwner = vehicleOwner;
    }

    public String getVehicleOwner() 
    {
        return vehicleOwner;
    }

    public String getTellPhone() {
        return tellPhone;
    }

    public void setTellPhone(String tellPhone) {
        this.tellPhone = tellPhone;
    }

    public void setCarNum(String carNum)
    {
        this.carNum = carNum;
    }

    public String getCarNum() 
    {
        return carNum;
    }
    public void setVehicleDisplacement(String vehicleDisplacement) 
    {
        this.vehicleDisplacement = vehicleDisplacement;
    }

    public String getVehicleDisplacement() 
    {
        return vehicleDisplacement;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cellId", getCellId())
            .append("vehicleNum", getVehicleNum())
            .append("parkingNum", getParkingNum())
            .append("parkingCardNum", getParkingCardNum())
            .append("vehicleOwner", getVehicleOwner())
            .append("tellPhone", getTellPhone())
            .append("carNum", getCarNum())
            .append("vehicleDisplacement", getVehicleDisplacement())
            .append("userId", getUserId())
            .toString();
    }
}
