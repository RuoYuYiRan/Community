package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Building;

/**
 * 楼宇管理Service接口
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
public interface IBuildingService 
{
    /**
     * 查询楼宇管理
     * 
     * @param id 楼宇管理ID
     * @return 楼宇管理
     */
    public Building selectBuildingById(Integer id);

    /**
     * 查询楼宇管理列表
     * 
     * @param building 楼宇管理
     * @return 楼宇管理集合
     */
    public List<Building> selectBuildingList(Building building);

    /**
     * 新增楼宇管理
     * 
     * @param building 楼宇管理
     * @return 结果
     */
    public int insertBuilding(Building building);

    /**
     * 修改楼宇管理
     * 
     * @param building 楼宇管理
     * @return 结果
     */
    public int updateBuilding(Building building);

    /**
     * 批量删除楼宇管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBuildingByIds(String ids);

    /**
     * 删除楼宇管理信息
     * 
     * @param id 楼宇管理ID
     * @return 结果
     */
    public int deleteBuildingById(Integer id);

    /**
     * 查询楼宇Id和BuildName
     * @return
     */
    public List<Building> selectIdAndBuildName();
}
