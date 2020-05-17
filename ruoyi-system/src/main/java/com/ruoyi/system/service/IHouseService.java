package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.House;

/**
 * 房屋管理Service接口
 * 
 * @author yu
 * @date 2020-04-15
 */
public interface IHouseService 
{
    /**
     * 查询房屋管理
     * 
     * @param id 房屋管理ID
     * @return 房屋管理
     */
    public House selectHouseById(Integer id);

    /**
     * 查询房屋管理列表
     * 
     * @param house 房屋管理
     * @return 房屋管理集合
     */
    public List<House> selectHouseList(House house);

    /**
     * 新增房屋管理
     * 
     * @param house 房屋管理
     * @return 结果
     */
    public int insertHouse(House house);

    /**
     * 修改房屋管理
     * 
     * @param house 房屋管理
     * @return 结果
     */
    public int updateHouse(House house);

    /**
     * 批量删除房屋管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHouseByIds(String ids);

    /**
     * 删除房屋管理信息
     * 
     * @param id 房屋管理ID
     * @return 结果
     */
    public int deleteHouseById(Integer id);

    /**
     * 查询发那个屋Id和房屋Name
     * @return
     */
    public List<House> selectIdAndUnitNum();
}
