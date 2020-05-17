package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Vehicle;

/**
 * 车辆管理Mapper接口
 * 
 * @author yu
 * @date 2020-04-15
 */
public interface VehicleMapper 
{
    /**
     * 查询车辆管理
     * 
     * @param id 车辆管理ID
     * @return 车辆管理
     */
    public Vehicle selectVehicleById(Integer id);

    /**
     * 查询车辆管理列表
     * 
     * @param vehicle 车辆管理
     * @return 车辆管理集合
     */
    public List<Vehicle> selectVehicleList(Vehicle vehicle);

    /**
     * 新增车辆管理
     * 
     * @param vehicle 车辆管理
     * @return 结果
     */
    public int insertVehicle(Vehicle vehicle);

    /**
     * 修改车辆管理
     * 
     * @param vehicle 车辆管理
     * @return 结果
     */
    public int updateVehicle(Vehicle vehicle);

    /**
     * 删除车辆管理
     * 
     * @param id 车辆管理ID
     * @return 结果
     */
    public int deleteVehicleById(Integer id);

    /**
     * 批量删除车辆管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVehicleByIds(String[] ids);
}
