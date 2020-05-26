package com.ruoyi.system.service;

import com.ruoyi.system.domain.Complaint;
import com.ruoyi.system.domain.Warranty;

import java.util.List;

/**
 * 投诉IComplaintService接口
 * @date 2020-4-21
 */
public interface IComplaintService {
    /**
     * 查询投诉
     *
     * @param id 投诉ID
     * @return 投诉
     */
    public Complaint selectComplaintById(Integer id);

    /**
     * 查询投诉列表
     *
     * @param complaint 投诉
     * @return 投诉集合
     */
    public List<Complaint> selectComplaintList(Complaint complaint);

    /**
     * 新增投诉
     *
     * @param complaint 投诉
     * @return 结果
     */
    public int insertComplaint(Complaint complaint);

    /**
     * 修改投诉
     *
     * @param complaint 投诉
     * @return 结果
     */
    public int updateComplaint(Complaint complaint);

    /**
     * 批量删除投诉
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteComplaintByIds(String ids);

    /**
     * 删除投诉信息
     *
     * @param id 保修ID
     * @return 结果
     */
    public int deleteComplaintById(Integer id);

}
