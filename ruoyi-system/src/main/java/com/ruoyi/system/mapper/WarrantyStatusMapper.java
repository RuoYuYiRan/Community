package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.WarrantyStatus;

/**
 * VIEWMapper接口
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public interface WarrantyStatusMapper 
{
    /**
     * 查询VIEW
     * 
     * @param countsta VIEWID
     * @return VIEW
     */
    public WarrantyStatus selectWarrantyStatusById(Long countsta);

    /**
     * 查询VIEW列表
     * 
     * @param warrantyStatus VIEW
     * @return VIEW集合
     */
    public List<WarrantyStatus> selectWarrantyStatusList(WarrantyStatus warrantyStatus);

    /**
     * 新增VIEW
     * 
     * @param warrantyStatus VIEW
     * @return 结果
     */
    public int insertWarrantyStatus(WarrantyStatus warrantyStatus);

    /**
     * 修改VIEW
     * 
     * @param warrantyStatus VIEW
     * @return 结果
     */
    public int updateWarrantyStatus(WarrantyStatus warrantyStatus);

    /**
     * 删除VIEW
     * 
     * @param countsta VIEWID
     * @return 结果
     */
    public int deleteWarrantyStatusById(Long countsta);

    /**
     * 批量删除VIEW
     * 
     * @param countstas 需要删除的数据ID
     * @return 结果
     */
    public int deleteWarrantyStatusByIds(String[] countstas);
}
