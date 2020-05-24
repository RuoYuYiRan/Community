package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.House;
import com.ruoyi.system.domain.ResidentialQuarters;
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
import com.ruoyi.system.domain.Building;
import com.ruoyi.system.service.IBuildingService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

/**
 * 楼宇管理Controller
 * 
 * @author ruoyi
 * @date 2020-04-15
 */
@Controller
@RequestMapping("/system/building")
public class BuildingController extends BaseController
{
    private String prefix = "system/building";

    @Autowired
    private IBuildingService buildingService;

    //小区
    @Autowired
    private IResidentialQuartersService residentialQuartersService;


    @RequiresPermissions("system:building:view")
    @GetMapping()
    public String building()
    {
        return prefix + "/building";
    }

    /**
     * 查询楼宇管理列表
     */
    @RequiresPermissions("system:building:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Building building)
    {
        startPage();
        List<Building> list = buildingService.selectBuildingList(building);
        return getDataTable(list);
    }

    /**
     * 导出楼宇管理列表
     */
    @RequiresPermissions("system:building:export")
    @Log(title = "楼宇管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Building building)
    {
        List<Building> list = buildingService.selectBuildingList(building);
        ExcelUtil<Building> util = new ExcelUtil<Building>(Building.class);
        return util.exportExcel(list, "building");
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
        return mav;
    }

    /**
     * 新增保存楼宇管理
     */
    @RequiresPermissions("system:building:add")
    @Log(title = "楼宇管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Building building)
    {
        return toAjax(buildingService.insertBuilding(building));
    }

    /**
     * 修改楼宇管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        Building building = buildingService.selectBuildingById(id);
        mmap.put("building", building);
        return prefix + "/edit";
    }

    /**
     * 修改保存楼宇管理
     */
    @RequiresPermissions("system:building:edit")
    @Log(title = "楼宇管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Building building)
    {
        return toAjax(buildingService.updateBuilding(building));
    }

    /**
     * 删除楼宇管理
     */
    @RequiresPermissions("system:building:remove")
    @Log(title = "楼宇管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(buildingService.deleteBuildingByIds(ids));
    }
}
