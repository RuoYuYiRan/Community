package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ComplaintStatus;

/**
 * VIEWService接口
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public interface IComplaintStatusService 
{
    /**
     * 查询VIEW
     * 
     * @param countsta VIEWID
     * @return VIEW
     */
    public ComplaintStatus selectComplaintStatusById(Long countsta);

    /**
     * 查询VIEW列表
     * 
     * @param complaintStatus VIEW
     * @return VIEW集合
     */
    public List<ComplaintStatus> selectComplaintStatusList(ComplaintStatus complaintStatus);

    /**
     * 新增VIEW
     * 
     * @param complaintStatus VIEW
     * @return 结果
     */
    public int insertComplaintStatus(ComplaintStatus complaintStatus);

    /**
     * 修改VIEW
     * 
     * @param complaintStatus VIEW
     * @return 结果
     */
    public int updateComplaintStatus(ComplaintStatus complaintStatus);

    /**
     * 批量删除VIEW
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteComplaintStatusByIds(String ids);

    /**
     * 删除VIEW信息
     * 
     * @param countsta VIEWID
     * @return 结果
     */
    public int deleteComplaintStatusById(Long countsta);
}
