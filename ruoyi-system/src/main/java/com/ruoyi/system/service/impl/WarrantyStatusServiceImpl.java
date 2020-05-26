package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WarrantyStatusMapper;
import com.ruoyi.system.domain.WarrantyStatus;
import com.ruoyi.system.service.IWarrantyStatusService;
import com.ruoyi.common.core.text.Convert;

/**
 * VIEWService业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Service
public class WarrantyStatusServiceImpl implements IWarrantyStatusService 
{
    @Autowired
    private WarrantyStatusMapper warrantyStatusMapper;

    /**
     * 查询VIEW
     * 
     * @param countsta VIEWID
     * @return VIEW
     */
    @Override
    public WarrantyStatus selectWarrantyStatusById(Long countsta)
    {
        return warrantyStatusMapper.selectWarrantyStatusById(countsta);
    }

    /**
     * 查询VIEW列表
     * 
     * @param warrantyStatus VIEW
     * @return VIEW
     */
    @Override
    public List<WarrantyStatus> selectWarrantyStatusList(WarrantyStatus warrantyStatus)
    {
        return warrantyStatusMapper.selectWarrantyStatusList(warrantyStatus);
    }

    /**
     * 新增VIEW
     * 
     * @param warrantyStatus VIEW
     * @return 结果
     */
    @Override
    public int insertWarrantyStatus(WarrantyStatus warrantyStatus)
    {
        return warrantyStatusMapper.insertWarrantyStatus(warrantyStatus);
    }

    /**
     * 修改VIEW
     * 
     * @param warrantyStatus VIEW
     * @return 结果
     */
    @Override
    public int updateWarrantyStatus(WarrantyStatus warrantyStatus)
    {
        return warrantyStatusMapper.updateWarrantyStatus(warrantyStatus);
    }

    /**
     * 删除VIEW对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWarrantyStatusByIds(String ids)
    {
        return warrantyStatusMapper.deleteWarrantyStatusByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除VIEW信息
     * 
     * @param countsta VIEWID
     * @return 结果
     */
    @Override
    public int deleteWarrantyStatusById(Long countsta)
    {
        return warrantyStatusMapper.deleteWarrantyStatusById(countsta);
    }
}
