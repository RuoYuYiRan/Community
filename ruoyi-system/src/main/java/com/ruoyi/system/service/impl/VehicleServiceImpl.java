package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VehicleMapper;
import com.ruoyi.system.domain.Vehicle;
import com.ruoyi.system.service.IVehicleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 车辆管理Service业务层处理
 * 
 * @author yu
 * @date 2020-04-15
 */
@Service
public class VehicleServiceImpl implements IVehicleService 
{
    @Autowired
    private VehicleMapper vehicleMapper;

    /**
     * 查询车辆管理
     * 
     * @param id 车辆管理ID
     * @return 车辆管理
     */
    @Override
    public Vehicle selectVehicleById(Integer id)
    {
        return vehicleMapper.selectVehicleById(id);
    }

    /**
     * 查询车辆管理列表
     * 
     * @param vehicle 车辆管理
     * @return 车辆管理
     */
    @Override
    public List<Vehicle> selectVehicleList(Vehicle vehicle)
    {
        return vehicleMapper.selectVehicleList(vehicle);
    }

    /**
     * 新增车辆管理
     * 
     * @param vehicle 车辆管理
     * @return 结果
     */
    @Override
    public int insertVehicle(Vehicle vehicle)
    {
        return vehicleMapper.insertVehicle(vehicle);
    }

    /**
     * 修改车辆管理
     * 
     * @param vehicle 车辆管理
     * @return 结果
     */
    @Override
    public int updateVehicle(Vehicle vehicle)
    {
        return vehicleMapper.updateVehicle(vehicle);
    }

    /**
     * 删除车辆管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVehicleByIds(String ids)
    {
        return vehicleMapper.deleteVehicleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆管理信息
     * 
     * @param id 车辆管理ID
     * @return 结果
     */
    @Override
    public int deleteVehicleById(Integer id)
    {
        return vehicleMapper.deleteVehicleById(id);
    }
}
