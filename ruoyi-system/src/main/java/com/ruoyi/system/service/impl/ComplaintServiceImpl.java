package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Complaint;
import com.ruoyi.system.mapper.ComplaintMapper;
import com.ruoyi.system.service.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 投诉IComplaintService接口的实现类
 * @date 2020-4-21
 */
@Service
public class ComplaintServiceImpl implements IComplaintService {

   @Autowired
    private ComplaintMapper complaintMapper;

    /**
     * 查询投诉
     * @param id 投诉ID
     * @return
     */
    @Override
    public Complaint selectComplaintById(Integer id) {

        return complaintMapper.selectComplaintById(id);
    }

    /**
     * 查询投诉列表
     * @param complaint 投诉
     * @return
     */
    @Override
    public List<Complaint> selectComplaintList(Complaint complaint) {
        return complaintMapper.selectComplaintList(complaint);
    }

    /**
     * 新增投诉
     * @param complaint 投诉
     * @return
     */
    @Override
    public int insertComplaint(Complaint complaint) {

        complaint.setCreateTime(DateUtils.getNowDate());
        return complaintMapper.insertComplaint(complaint);
    }

    /**
     * 更新投诉
     * @param complaint 投诉
     * @return
     */
    @Override
    public int updateComplaint(Complaint complaint) {

        return complaintMapper.updateComplaint(complaint);
    }

    /**
     * 删除投诉对象
     * @param ids 需要删除的数据ID
     * @return
     */
    @Override
    public int deleteComplaintByIds(String ids) {

        return complaintMapper.deleteComplaintByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除投诉信息
     * @param id 保修ID
     * @return
     */
    @Override
    public int deleteComplaintById(Integer id) {

        return deleteComplaintById(id);
    }

}
