package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ResidentialQuarters;

/**
 * 社区管理Service接口
 * 
 * @author yu
 * @date 2020-04-15
 */
public interface IResidentialQuartersService 
{
    /**
     * 查询社区管理
     * 
     * @param id 社区管理ID
     * @return 社区管理
     */
    public ResidentialQuarters selectResidentialQuartersById(Integer id);

    /**
     * 查询社区管理列表
     * 
     * @param residentialQuarters 社区管理
     * @return 社区管理集合
     */
    public List<ResidentialQuarters> selectResidentialQuartersList(ResidentialQuarters residentialQuarters);

    /**
     * 新增社区管理
     * 
     * @param residentialQuarters 社区管理
     * @return 结果
     */
    public int insertResidentialQuarters(ResidentialQuarters residentialQuarters);

    /**
     * 修改社区管理
     * 
     * @param residentialQuarters 社区管理
     * @return 结果
     */
    public int updateResidentialQuarters(ResidentialQuarters residentialQuarters);

    /**
     * 批量删除社区管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteResidentialQuartersByIds(String ids);

    /**
     * 删除社区管理信息
     * 
     * @param id 社区管理ID
     * @return 结果
     */
    public int deleteResidentialQuartersById(Integer id);

    public List<ResidentialQuarters> selectCellIdAndCellName();
}
