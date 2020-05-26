package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;
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
import com.ruoyi.system.domain.ComplaintStatus;
import com.ruoyi.system.service.IComplaintStatusService;
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
@RequestMapping("/system/status")
public class ComplaintStatusController extends BaseController
{
    private String prefix = "system/status";

    @Autowired
    private IComplaintStatusService complaintStatusService;

    @RequiresPermissions("system:status:view")
    @GetMapping()
    public String status()
    {
        return prefix + "/status";
    }

    /**
     * 查询VIEW列表
     */
    @RequiresPermissions("system:status:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ComplaintStatus complaintStatus)
    {
        startPage();
        List<ComplaintStatus> list = complaintStatusService.selectComplaintStatusList(complaintStatus);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @RequiresPermissions("system:status:export")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ComplaintStatus complaintStatus)
    {
        List<ComplaintStatus> list = complaintStatusService.selectComplaintStatusList(complaintStatus);
        ExcelUtil<ComplaintStatus> util = new ExcelUtil<ComplaintStatus>(ComplaintStatus.class);
        return util.exportExcel(list, "status");
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
    @RequiresPermissions("system:status:add")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ComplaintStatus complaintStatus)
    {
        return toAjax(complaintStatusService.insertComplaintStatus(complaintStatus));
    }

    /**
     * 修改VIEW
     */
    @GetMapping("/edit/{countsta}")
    public String edit(@PathVariable("countsta") Long countsta, ModelMap mmap)
    {
        ComplaintStatus complaintStatus = complaintStatusService.selectComplaintStatusById(countsta);
        mmap.put("complaintStatus", complaintStatus);
        return prefix + "/edit";
    }

    /**
     * 修改保存VIEW
     */
    @RequiresPermissions("system:status:edit")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ComplaintStatus complaintStatus)
    {
        return toAjax(complaintStatusService.updateComplaintStatus(complaintStatus));
    }

    /**
     * 删除VIEW
     */
    @RequiresPermissions("system:status:remove")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(complaintStatusService.deleteComplaintStatusByIds(ids));
    }

    /**
     * 投诉状态处理数量，通过报表方式展示
     * @param model
     * @return
     */
    @RequestMapping(value = "/EcharsShow")
    @ResponseBody
    public List<ComplaintStatus> findComplaintStatus(Model model,ComplaintStatus complaintStatus) {
        List<ComplaintStatus> list = complaintStatusService.selectComplaintStatusList(complaintStatus);
        System.err.println(list.toString());
        return list;
    }

    @GetMapping(value = "/Echars.do")
    public String echarts4(Model model){
        System.err.println("========开始");
        return "Echars";
    }
}
