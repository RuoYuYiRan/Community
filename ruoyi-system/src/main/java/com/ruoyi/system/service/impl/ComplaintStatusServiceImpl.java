package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ComplaintStatusMapper;
import com.ruoyi.system.domain.ComplaintStatus;
import com.ruoyi.system.service.IComplaintStatusService;
import com.ruoyi.common.core.text.Convert;

/**
 * VIEWService业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Service
public class ComplaintStatusServiceImpl implements IComplaintStatusService 
{
    @Autowired
    private ComplaintStatusMapper complaintStatusMapper;

    /**
     * 查询VIEW
     * 
     * @param countsta VIEWID
     * @return VIEW
     */
    @Override
    public ComplaintStatus selectComplaintStatusById(Long countsta)
    {
        return complaintStatusMapper.selectComplaintStatusById(countsta);
    }

    /**
     * 查询VIEW列表
     * 
     * @param complaintStatus VIEW
     * @return VIEW
     */
    @Override
    public List<ComplaintStatus> selectComplaintStatusList(ComplaintStatus complaintStatus)
    {
        return complaintStatusMapper.selectComplaintStatusList(complaintStatus);
    }

    /**
     * 新增VIEW
     * 
     * @param complaintStatus VIEW
     * @return 结果
     */
    @Override
    public int insertComplaintStatus(ComplaintStatus complaintStatus)
    {
        return complaintStatusMapper.insertComplaintStatus(complaintStatus);
    }

    /**
     * 修改VIEW
     * 
     * @param complaintStatus VIEW
     * @return 结果
     */
    @Override
    public int updateComplaintStatus(ComplaintStatus complaintStatus)
    {
        return complaintStatusMapper.updateComplaintStatus(complaintStatus);
    }

    /**
     * 删除VIEW对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteComplaintStatusByIds(String ids)
    {
        return complaintStatusMapper.deleteComplaintStatusByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除VIEW信息
     * 
     * @param countsta VIEWID
     * @return 结果
     */
    @Override
    public int deleteComplaintStatusById(Long countsta)
    {
        return complaintStatusMapper.deleteComplaintStatusById(countsta);
    }
}
