package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.House;
import org.apache.ibatis.annotations.Param;

/**
 * 房屋管理Mapper接口
 * 
 * @author yu
 * @date 2020-04-15
 */
public interface HouseMapper 
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
     * 删除房屋管理
     * 
     * @param id 房屋管理ID
     * @return 结果
     */
    public int deleteHouseById(Integer id);

    /**
     * 批量删除房屋管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHouseByIds(String[] ids);

    /**
     * 查询发那个屋Id和房屋Name
     * @return
     */
    public List<House> selectIdAndUnitNum();

    /**
     * 根据信息验证
     * @param phoneNum
     * @param unitNum
     * @param buildId
     * @param cellId
     * @return
     */
    public int queryHouseByInfo(@Param("phoneNum") String phoneNum, @Param("unitNum")Integer unitNum, @Param("buildId")Integer buildId, @Param("cellId")Integer cellId);
}
