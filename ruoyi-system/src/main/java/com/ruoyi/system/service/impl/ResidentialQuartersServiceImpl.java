package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ResidentialQuartersMapper;
import com.ruoyi.system.domain.ResidentialQuarters;
import com.ruoyi.system.service.IResidentialQuartersService;
import com.ruoyi.common.core.text.Convert;

/**
 * 社区管理Service业务层处理
 * 
 * @author yu
 * @date 2020-04-15
 */
@Service
public class ResidentialQuartersServiceImpl implements IResidentialQuartersService 
{
    @Autowired
    private ResidentialQuartersMapper residentialQuartersMapper;

    /**
     * 查询社区管理
     * 
     * @param id 社区管理ID
     * @return 社区管理
     */
    @Override
    public ResidentialQuarters selectResidentialQuartersById(Integer id)
    {
        return residentialQuartersMapper.selectResidentialQuartersById(id);
    }

    /**
     * 查询社区管理列表
     * 
     * @param residentialQuarters 社区管理
     * @return 社区管理
     */
    @Override
    public List<ResidentialQuarters> selectResidentialQuartersList(ResidentialQuarters residentialQuarters)
    {
        return residentialQuartersMapper.selectResidentialQuartersList(residentialQuarters);
    }

    /**
     * 新增社区管理
     * 
     * @param residentialQuarters 社区管理
     * @return 结果
     */
    @Override
    public int insertResidentialQuarters(ResidentialQuarters residentialQuarters)
    {
        return residentialQuartersMapper.insertResidentialQuarters(residentialQuarters);
    }

    /**
     * 修改社区管理
     * 
     * @param residentialQuarters 社区管理
     * @return 结果
     */
    @Override
    public int updateResidentialQuarters(ResidentialQuarters residentialQuarters)
    {
        return residentialQuartersMapper.updateResidentialQuarters(residentialQuarters);
    }

    /**
     * 删除社区管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteResidentialQuartersByIds(String ids)
    {
        return residentialQuartersMapper.deleteResidentialQuartersByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除社区管理信息
     * 
     * @param id 社区管理ID
     * @return 结果
     */
    @Override
    public int deleteResidentialQuartersById(Integer id)
    {
        return residentialQuartersMapper.deleteResidentialQuartersById(id);
    }

    @Override
    public List<ResidentialQuarters> selectCellIdAndCellName() {
        return residentialQuartersMapper.selectCellNameByCellId();
    }
}
