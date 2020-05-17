package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.WarrantyMapper;
import com.ruoyi.system.domain.Warranty;
import com.ruoyi.system.service.IWarrantyService;
import com.ruoyi.common.core.text.Convert;

/**
 * 保修Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
@Service
public class WarrantyServiceImpl implements IWarrantyService 
{
    @Autowired
    private WarrantyMapper warrantyMapper;

    /**
     * 查询保修
     * 
     * @param id 保修ID
     * @return 保修
     */
    @Override
    public Warranty selectWarrantyById(Integer id)
    {
        return warrantyMapper.selectWarrantyById(id);
    }

    /**
     * 查询保修列表
     * 
     * @param warranty 保修
     * @return 保修
     */
    @Override
    public List<Warranty> selectWarrantyList(Warranty warranty)
    {
        return warrantyMapper.selectWarrantyList(warranty);
    }

    /**
     * 新增保修
     * 
     * @param warranty 保修
     * @return 结果
     */
    @Override
    public int insertWarranty(Warranty warranty)
    {
        warranty.setCreateTime(DateUtils.getNowDate());
        return warrantyMapper.insertWarranty(warranty);
    }

    /**
     * 修改保修
     * 
     * @param warranty 保修
     * @return 结果
     */
    @Override
    public int updateWarranty(Warranty warranty)
    {
        return warrantyMapper.updateWarranty(warranty);
    }

    /**
     * 删除保修对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWarrantyByIds(String ids)
    {
        return warrantyMapper.deleteWarrantyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除保修信息
     * 
     * @param id 保修ID
     * @return 结果
     */
    @Override
    public int deleteWarrantyById(Integer id)
    {
        return warrantyMapper.deleteWarrantyById(id);
    }
}
