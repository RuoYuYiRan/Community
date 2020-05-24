package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房屋管理对象 house
 * 
 * @author yu
 * @date 2020-04-15
 */
public class House extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房屋id */
    private Integer id;

    /** 小区 */
    @Excel(name = "null")
    private Integer cellId;

    /** 楼宇 */
    @Excel(name = "null")
    private Integer buildId;

    /** 单元 */
    @Excel(name = "null")
    private Integer unitNum;

    /** 楼层 */
    @Excel(name = "null")
    private Integer floor;

    /** 门牌号 */
    @Excel(name = "null")
    private Integer roomNum;

    /** 楼层面积 */
    @Excel(name = "null")
    private String floorArea;

    /** 房屋面积 */
    @Excel(name = "null")
    private String houseArea;

    /** 统筹面积 */
    @Excel(name = "null")
    private String poolArea;

    /** 房屋类型 */
    @Excel(name = "null")
    private String roomType;

    /** 卧室 */
    @Excel(name = "null")
    private Integer houseRoom;

    /** 书房 */
    @Excel(name = "null")
    private Integer houseOffice;

    /** 卫生间 */
    @Excel(name = "null")
    private Integer houseBathroom;

    //小区
    private ResidentialQuarters residentialQuarters;

    //楼宇
    private Building building;

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
    public void setUnitNum(Integer unitNum) 
    {
        this.unitNum = unitNum;
    }

    public Integer getUnitNum() 
    {
        return unitNum;
    }
    public void setFloor(Integer floor) 
    {
        this.floor = floor;
    }

    public Integer getFloor() 
    {
        return floor;
    }
    public void setRoomNum(Integer roomNum) 
    {
        this.roomNum = roomNum;
    }

    public Integer getRoomNum() 
    {
        return roomNum;
    }
    public void setFloorArea(String floorArea) 
    {
        this.floorArea = floorArea;
    }

    public String getFloorArea() 
    {
        return floorArea;
    }
    public void setHouseArea(String houseArea) 
    {
        this.houseArea = houseArea;
    }

    public String getHouseArea() 
    {
        return houseArea;
    }
    public void setPoolArea(String poolArea) 
    {
        this.poolArea = poolArea;
    }

    public String getPoolArea() 
    {
        return poolArea;
    }
    public void setRoomType(String roomType) 
    {
        this.roomType = roomType;
    }

    public String getRoomType() 
    {
        return roomType;
    }
    public void setHouseRoom(Integer houseRoom) 
    {
        this.houseRoom = houseRoom;
    }

    public Integer getHouseRoom() 
    {
        return houseRoom;
    }
    public void setHouseOffice(Integer houseOffice) 
    {
        this.houseOffice = houseOffice;
    }

    public Integer getHouseOffice() 
    {
        return houseOffice;
    }
    public void setHouseBathroom(Integer houseBathroom) 
    {
        this.houseBathroom = houseBathroom;
    }

    public Integer getHouseBathroom() 
    {
        return houseBathroom;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cellId", getCellId())
            .append("buildId", getBuildId())
            .append("unitNum", getUnitNum())
            .append("floor", getFloor())
            .append("roomNum", getRoomNum())
            .append("floorArea", getFloorArea())
            .append("houseArea", getHouseArea())
            .append("poolArea", getPoolArea())
            .append("roomType", getRoomType())
            .append("houseRoom", getHouseRoom())
            .append("houseOffice", getHouseOffice())
            .append("houseBathroom", getHouseBathroom())
            .toString();
    }
}
