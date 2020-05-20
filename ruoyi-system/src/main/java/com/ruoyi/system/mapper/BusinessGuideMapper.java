package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BusinessGuide;

/**
 * 办事指南Mapper接口
 * 
 * @author yu
 * @date 2020-04-15
 */
public interface BusinessGuideMapper 
{
    /**
     * 查询办事指南
     * 
     * @param id 办事指南ID
     * @return 办事指南
     */
    public BusinessGuide selectBusinessGuideById(Integer id);

    /**
     * 查询办事指南列表
     * 
     * @param businessGuide 办事指南
     * @return 办事指南集合
     */
    public List<BusinessGuide> selectBusinessGuideList(BusinessGuide businessGuide);

    /**
     * 新增办事指南
     * 
     * @param businessGuide 办事指南
     * @return 结果
     */
    public int insertBusinessGuide(BusinessGuide businessGuide);

    /**
     * 修改办事指南
     * 
     * @param businessGuide 办事指南
     * @return 结果
     */
    public int updateBusinessGuide(BusinessGuide businessGuide);

    /**
     * 删除办事指南
     * 
     * @param id 办事指南ID
     * @return 结果
     */
    public int deleteBusinessGuideById(Integer id);

    /**
     * 批量删除办事指南
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteBusinessGuideByIds(String[] ids);

    /**
     * 根据时间查询最新的三条数据
     * @return
     */
    public List<BusinessGuide> getGuideOrderByTime(BusinessGuide businessGuide);
}
