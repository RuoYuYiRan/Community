package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BuildingMapper;
import com.ruoyi.system.domain.Building;
import com.ruoyi.system.service.IBuildingService;
import com.ruoyi.common.core.text.Convert;

/**
 * 楼宇管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
@Service
public class BuildingServiceImpl implements IBuildingService 
{
    @Autowired
    private BuildingMapper buildingMapper;

    /**
     * 查询楼宇管理
     * 
     * @param id 楼宇管理ID
     * @return 楼宇管理
     */
    @Override
    public Building selectBuildingById(Integer id)
    {
        return buildingMapper.selectBuildingById(id);
    }

    /**
     * 查询楼宇管理列表
     * 
     * @param building 楼宇管理
     * @return 楼宇管理
     */
    @Override
    public List<Building> selectBuildingList(Building building)
    {
        return buildingMapper.selectBuildingList(building);
    }

    /**
     * 新增楼宇管理
     * 
     * @param building 楼宇管理
     * @return 结果
     */
    @Override
    public int insertBuilding(Building building)
    {
        return buildingMapper.insertBuilding(building);
    }

    /**
     * 修改楼宇管理
     * 
     * @param building 楼宇管理
     * @return 结果
     */
    @Override
    public int updateBuilding(Building building)
    {
        return buildingMapper.updateBuilding(building);
    }

    /**
     * 删除楼宇管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBuildingByIds(String ids)
    {
        return buildingMapper.deleteBuildingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除楼宇管理信息
     * 
     * @param id 楼宇管理ID
     * @return 结果
     */
    @Override
    public int deleteBuildingById(Integer id)
    {
        return buildingMapper.deleteBuildingById(id);
    }

    /**
     * 查询楼宇Id和楼宇Name
     * @return
     */
    @Override
    public List<Building> selectIdAndBuildName() {
        return buildingMapper.selectIdAndBuildName();
    }
}
