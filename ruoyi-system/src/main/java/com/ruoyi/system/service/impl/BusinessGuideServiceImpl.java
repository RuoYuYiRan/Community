package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusinessGuideMapper;
import com.ruoyi.system.domain.BusinessGuide;
import com.ruoyi.system.service.IBusinessGuideService;
import com.ruoyi.common.core.text.Convert;

/**
 * 办事指南Service业务层处理
 * 
 * @author yu
 * @date 2020-04-15
 */
@Service
public class BusinessGuideServiceImpl implements IBusinessGuideService 
{
    @Autowired
    private BusinessGuideMapper businessGuideMapper;

    /**
     * 查询办事指南
     * 
     * @param id 办事指南ID
     * @return 办事指南
     */
    @Override
    public BusinessGuide selectBusinessGuideById(Integer id)
    {
        return businessGuideMapper.selectBusinessGuideById(id);
    }

    /**
     * 查询办事指南列表
     * 
     * @param businessGuide 办事指南
     * @return 办事指南
     */
    @Override
    public List<BusinessGuide> selectBusinessGuideList(BusinessGuide businessGuide)
    {
        return businessGuideMapper.selectBusinessGuideList(businessGuide);
    }

    /**
     * 新增办事指南
     * 
     * @param businessGuide 办事指南
     * @return 结果
     */
    @Override
    public int insertBusinessGuide(BusinessGuide businessGuide)
    {
        return businessGuideMapper.insertBusinessGuide(businessGuide);
    }

    /**
     * 修改办事指南
     * 
     * @param businessGuide 办事指南
     * @return 结果
     */
    @Override
    public int updateBusinessGuide(BusinessGuide businessGuide)
    {
        return businessGuideMapper.updateBusinessGuide(businessGuide);
    }

    /**
     * 删除办事指南对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBusinessGuideByIds(String ids)
    {
        return businessGuideMapper.deleteBusinessGuideByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除办事指南信息
     * 
     * @param id 办事指南ID
     * @return 结果
     */
    @Override
    public int deleteBusinessGuideById(Integer id)
    {
        return businessGuideMapper.deleteBusinessGuideById(id);
    }
}
