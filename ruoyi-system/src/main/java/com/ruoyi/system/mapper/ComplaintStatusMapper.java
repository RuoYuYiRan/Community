package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ComplaintStatus;

/**
 * VIEWMapper接口
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
public interface ComplaintStatusMapper 
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
     * 删除VIEW
     * 
     * @param countsta VIEWID
     * @return 结果
     */
    public int deleteComplaintStatusById(Long countsta);

    /**
     * 批量删除VIEW
     * 
     * @param countstas 需要删除的数据ID
     * @return 结果
     */
    public int deleteComplaintStatusByIds(String[] countstas);
}
