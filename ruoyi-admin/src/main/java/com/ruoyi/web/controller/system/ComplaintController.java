package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Building;
import com.ruoyi.system.domain.Complaint;
import com.ruoyi.system.domain.House;
import com.ruoyi.system.domain.ResidentialQuarters;
import com.ruoyi.system.service.IBuildingService;
import com.ruoyi.system.service.IComplaintService;
import com.ruoyi.system.service.IHouseService;
import com.ruoyi.system.service.IResidentialQuartersService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/system/complaint")
public class ComplaintController extends BaseController {
    private String prefix = "system/complaint";

    @Autowired
    private IComplaintService complaintService;

    //小区
    @Autowired
    private IResidentialQuartersService residentialQuartersService;

    //楼宇
    @Autowired
    private IBuildingService buildingService;

    //房屋
    @Autowired
    private IHouseService houseService;

    @RequiresPermissions("system:complaint:view")
    @GetMapping()
    public String complaint()
    {
        return prefix + "/complaint";
    }

    /**
     * 查询投诉列表
     */
    @RequiresPermissions("system:complaint:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Complaint complaint)
    {
        startPage();
        List<Complaint> list = complaintService.selectComplaintList(complaint);
        return getDataTable(list);
    }

    /**
     * 导出投诉列表
     */
    @RequiresPermissions("system:complaint:export")
    @Log(title = "投诉", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Complaint complaint)
    {
        List<Complaint> list = complaintService.selectComplaintList(complaint);
        ExcelUtil<Complaint> util = new ExcelUtil<Complaint>(Complaint.class);
        return util.exportExcel(list, "complaint");
    }

    /**
     * 新增投诉
     */
    @GetMapping("/add")
    public ModelAndView add()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName( prefix + "/add");
        //小区
        List<ResidentialQuarters> cells = residentialQuartersService.selectCellIdAndCellName();
        mav.addObject("cells",cells);
        //楼宇
        List<Building> builds = buildingService.selectIdAndBuildName();
        mav.addObject("builds",builds);
        //房屋
        List<House> houses = houseService.selectIdAndUnitNum();
        mav.addObject("houses",houses);
        //返回mav对象
        return mav;
    }

    /**
     * 新增投诉
     */
    @RequiresPermissions("system:complaint:add")
    @Log(title = "投诉", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Complaint complaint)
    {

        return toAjax(complaintService.insertComplaint(complaint));
    }

    /**
     * 居民上报投诉
     */
    @RequiresPermissions("system:complaint:refer")
    @Log(title = "投诉", businessType = BusinessType.INSERT)
    @PostMapping("/refer")
    @ResponseBody
    public AjaxResult refer(Complaint complaint)
    {

        return toAjax(complaintService.insertComplaint(complaint));
    }

    /**
     * 修改投诉
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        Complaint complaint = complaintService.selectComplaintById(id);
        mmap.put("complaint", complaint);
        return prefix + "/edit";
    }

    /**
     * 修改投诉
     */
    @RequiresPermissions("system:complaint:edit")
    @Log(title = "投诉", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Complaint complaint)
    {
        return toAjax(complaintService.updateComplaint(complaint));
    }

    /**
     * 删除投诉
     */
    @RequiresPermissions("system:complaint:remove")
    @Log(title = "投诉", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(complaintService.deleteComplaintByIds(ids));
    }
}
