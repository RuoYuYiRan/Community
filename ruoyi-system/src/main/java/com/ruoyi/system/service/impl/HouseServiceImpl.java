package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HouseMapper;
import com.ruoyi.system.domain.House;
import com.ruoyi.system.service.IHouseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 房屋管理Service业务层处理
 * 
 * @author yu
 * @date 2020-04-15
 */
@Service
public class HouseServiceImpl implements IHouseService 
{
    @Autowired
    private HouseMapper houseMapper;

    /**
     * 查询房屋管理
     * 
     * @param id 房屋管理ID
     * @return 房屋管理
     */
    @Override
    public House selectHouseById(Integer id)
    {
        return houseMapper.selectHouseById(id);
    }

    /**
     * 查询房屋管理列表
     * 
     * @param house 房屋管理
     * @return 房屋管理
     */
    @Override
    public List<House> selectHouseList(House house)
    {
        return houseMapper.selectHouseList(house);
    }

    /**
     * 新增房屋管理
     * 
     * @param house 房屋管理
     * @return 结果
     */
    @Override
    public int insertHouse(House house)
    {
        return houseMapper.insertHouse(house);
    }

    /**
     * 修改房屋管理
     * 
     * @param house 房屋管理
     * @return 结果
     */
    @Override
    public int updateHouse(House house)
    {
        return houseMapper.updateHouse(house);
    }

    /**
     * 删除房屋管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHouseByIds(String ids)
    {
        return houseMapper.deleteHouseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除房屋管理信息
     * 
     * @param id 房屋管理ID
     * @return 结果
     */
    @Override
    public int deleteHouseById(Integer id)
    {
        return houseMapper.deleteHouseById(id);
    }

    /**
     * 查询房屋ID 和单元号
     * @return
     */
    @Override
    public List<House> selectIdAndUnitNum() {
        return houseMapper.selectIdAndUnitNum();
    }

}
