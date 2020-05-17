package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.Building;
import com.ruoyi.system.domain.House;
import com.ruoyi.system.domain.ResidentialQuarters;
import com.ruoyi.system.service.IBuildingService;
import com.ruoyi.system.service.IHouseService;
import com.ruoyi.system.service.IResidentialQuartersService;
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
import com.ruoyi.system.domain.Warranty;
import com.ruoyi.system.service.IWarrantyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

/**
 * 保修Controller
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
@Controller
@RequestMapping("/system/warranty")
public class WarrantyController extends BaseController
{
    private String prefix = "system/warranty";

    @Autowired
    private IWarrantyService warrantyService;

    //小区
    @Autowired
    private IResidentialQuartersService residentialQuartersService;

    //楼宇
    @Autowired
    private IBuildingService buildingService;

    //房屋
    @Autowired
    private IHouseService houseService;

    @RequiresPermissions("system:warranty:view")
    @GetMapping()
    public String warranty()
    {
        return prefix + "/warranty";
    }

    /**
     * 查询保修列表
     */
    @RequiresPermissions("system:warranty:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Warranty warranty)
    {
        startPage();
        List<Warranty> list = warrantyService.selectWarrantyList(warranty);
        return getDataTable(list);
    }

    /**
     * 导出保修列表
     */
    @RequiresPermissions("system:warranty:export")
    @Log(title = "保修", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Warranty warranty)
    {
        List<Warranty> list = warrantyService.selectWarrantyList(warranty);
        ExcelUtil<Warranty> util = new ExcelUtil<Warranty>(Warranty.class);
        return util.exportExcel(list, "warranty");
    }

    /**
     * 新增保修
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
     * 新增保存保修
     */
    @RequiresPermissions("system:warranty:add")
    @Log(title = "保修", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Warranty warranty)
    {
        return toAjax(warrantyService.insertWarranty(warranty));
    }

    /**
     * 修改保修
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        Warranty warranty = warrantyService.selectWarrantyById(id);
        mmap.put("warranty", warranty);
        return prefix + "/edit";
    }

    /**
     * 修改保存保修
     */
    @RequiresPermissions("system:warranty:edit")
    @Log(title = "保修", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Warranty warranty)
    {
        return toAjax(warrantyService.updateWarranty(warranty));
    }

    /**
     * 删除保修
     */
    @RequiresPermissions("system:warranty:remove")
    @Log(title = "保修", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(warrantyService.deleteWarrantyByIds(ids));
    }
}