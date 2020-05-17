package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Warranty;

/**
 * 保修Service接口
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
public interface IWarrantyService 
{
    /**
     * 查询保修
     * 
     * @param id 保修ID
     * @return 保修
     */
    public Warranty selectWarrantyById(Integer id);

    /**
     * 查询保修列表
     * 
     * @param warranty 保修
     * @return 保修集合
     */
    public List<Warranty> selectWarrantyList(Warranty warranty);

    /**
     * 新增保修
     * 
     * @param warranty 保修
     * @return 结果
     */
    public int insertWarranty(Warranty warranty);

    /**
     * 修改保修
     * 
     * @param warranty 保修
     * @return 结果
     */
    public int updateWarranty(Warranty warranty);

    /**
     * 批量删除保修
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWarrantyByIds(String ids);

    /**
     * 删除保修信息
     * 
     * @param id 保修ID
     * @return 结果
     */
    public int deleteWarrantyById(Integer id);
}
