package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.ComplaintStatus;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.WarrantyStatus;
import com.ruoyi.system.service.IWarrantyStatusService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author ruoyi
 * @date 2020-05-26
 */
@Controller
@RequestMapping("/system/warrantyStatus")
public class WarrantyStatusController extends BaseController
{
    private String prefix = "system/warrantyStatus";

    @Autowired
    private IWarrantyStatusService warrantyStatusService;

    @RequiresPermissions("system:warrantyStatus:view")
    @GetMapping()
    public String status()
    {
        return prefix + "/warrantyStatus";
    }

    /**
     * 查询VIEW列表
     */
    @RequiresPermissions("system:warrantyStatus:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WarrantyStatus warrantyStatus)
    {
        startPage();
        List<WarrantyStatus> list = warrantyStatusService.selectWarrantyStatusList(warrantyStatus);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @RequiresPermissions("system:warrantyStatus:export")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WarrantyStatus warrantyStatus)
    {
        List<WarrantyStatus> list = warrantyStatusService.selectWarrantyStatusList(warrantyStatus);
        ExcelUtil<WarrantyStatus> util = new ExcelUtil<WarrantyStatus>(WarrantyStatus.class);
        return util.exportExcel(list, "warrantyStatus");
    }

    /**
     * 新增VIEW
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存VIEW
     */
    @RequiresPermissions("system:warrantyStatus:add")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WarrantyStatus warrantyStatus)
    {
        return toAjax(warrantyStatusService.insertWarrantyStatus(warrantyStatus));
    }

    /**
     * 修改VIEW
     */
    @GetMapping("/edit/{countsta}")
    public String edit(@PathVariable("countsta") Long countsta, ModelMap mmap)
    {
        WarrantyStatus warrantyStatus = warrantyStatusService.selectWarrantyStatusById(countsta);
        mmap.put("warrantyStatus", warrantyStatus);
        return prefix + "/edit";
    }

    /**
     * 修改保存VIEW
     */
    @RequiresPermissions("system:warrantyStatus:edit")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WarrantyStatus warrantyStatus)
    {
        return toAjax(warrantyStatusService.updateWarrantyStatus(warrantyStatus));
    }

    /**
     * 删除VIEW
     */
    @RequiresPermissions("system:warrantyStatus:remove")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(warrantyStatusService.deleteWarrantyStatusByIds(ids));
    }

    /**
     * 投诉状态处理数量，通过报表方式展示
     * @param model
     * @return
     */
    @RequestMapping(value = "/EcharsShow")
    @ResponseBody
    public List<WarrantyStatus> findComplaintStatus(Model model, WarrantyStatus warrantyStatus) {
        List<WarrantyStatus> list = warrantyStatusService.selectWarrantyStatusList(warrantyStatus);
        System.err.println(list.toString());
        return list;
    }

    @GetMapping(value = "/Echars.do")
    public String echarts4(Model model){
        System.err.println("========开始");
        return "Echars";
    }

}
