package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.ResidentialQuarters;
import com.ruoyi.system.service.IResidentialQuartersService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社区管理Controller
 * 
 * @author yu
 * @date 2020-04-15
 */
@Controller
@RequestMapping("/system/quarters")
public class ResidentialQuartersController extends BaseController
{
    private String prefix = "system/quarters";

    @Autowired
    private IResidentialQuartersService residentialQuartersService;

    @RequiresPermissions("system:quarters:view")
    @GetMapping()
    public String quarters()
    {
        return prefix + "/quarters";
    }

    /**
     * 查询社区管理列表
     */
    @RequiresPermissions("system:quarters:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ResidentialQuarters residentialQuarters)
    {
        startPage();
        List<ResidentialQuarters> list = residentialQuartersService.selectResidentialQuartersList(residentialQuarters);
        return getDataTable(list);
    }

    /**
     * 导出社区管理列表
     */
    @RequiresPermissions("system:quarters:export")
    @Log(title = "社区管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ResidentialQuarters residentialQuarters)
    {
        List<ResidentialQuarters> list = residentialQuartersService.selectResidentialQuartersList(residentialQuarters);
        ExcelUtil<ResidentialQuarters> util = new ExcelUtil<ResidentialQuarters>(ResidentialQuarters.class);
        return util.exportExcel(list, "quarters");
    }

    /**
     * 新增社区管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存社区管理
     */
    @RequiresPermissions("system:quarters:add")
    @Log(title = "社区管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ResidentialQuarters residentialQuarters)
    {
        return toAjax(residentialQuartersService.insertResidentialQuarters(residentialQuarters));
    }

    /**
     * 修改社区管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        ResidentialQuarters residentialQuarters = residentialQuartersService.selectResidentialQuartersById(id);
        mmap.put("residentialQuarters", residentialQuarters);
        return prefix + "/edit";
    }

    /**
     * 修改保存社区管理
     */
    @RequiresPermissions("system:quarters:edit")
    @Log(title = "社区管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ResidentialQuarters residentialQuarters)
    {
        return toAjax(residentialQuartersService.updateResidentialQuarters(residentialQuarters));
    }

    /**
     * 删除社区管理
     */
    @RequiresPermissions("system:quarters:remove")
    @Log(title = "社区管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(residentialQuartersService.deleteResidentialQuartersByIds(ids));
    }
}
