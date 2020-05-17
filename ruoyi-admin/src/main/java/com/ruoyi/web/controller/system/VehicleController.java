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
import com.ruoyi.system.domain.Vehicle;
import com.ruoyi.system.service.IVehicleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆管理Controller
 * 
 * @author yu
 * @date 2020-04-15
 */
@Controller
@RequestMapping("/system/vehicle")
public class VehicleController extends BaseController
{
    private String prefix = "system/vehicle";

    @Autowired
    private IVehicleService vehicleService;

    @RequiresPermissions("system:vehicle:view")
    @GetMapping()
    public String vehicle()
    {
        return prefix + "/vehicle";
    }

    /**
     * 查询车辆管理列表
     */
    @RequiresPermissions("system:vehicle:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Vehicle vehicle)
    {
        startPage();
        List<Vehicle> list = vehicleService.selectVehicleList(vehicle);
        return getDataTable(list);
    }

    /**
     * 导出车辆管理列表
     */
    @RequiresPermissions("system:vehicle:export")
    @Log(title = "车辆管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Vehicle vehicle)
    {
        List<Vehicle> list = vehicleService.selectVehicleList(vehicle);
        ExcelUtil<Vehicle> util = new ExcelUtil<Vehicle>(Vehicle.class);
        return util.exportExcel(list, "vehicle");
    }

    /**
     * 新增车辆管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存车辆管理
     */
    @RequiresPermissions("system:vehicle:add")
    @Log(title = "车辆管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Vehicle vehicle)
    {
        return toAjax(vehicleService.insertVehicle(vehicle));
    }

    /**
     * 修改车辆管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        Vehicle vehicle = vehicleService.selectVehicleById(id);
        mmap.put("vehicle", vehicle);
        return prefix + "/edit";
    }

    /**
     * 修改保存车辆管理
     */
    @RequiresPermissions("system:vehicle:edit")
    @Log(title = "车辆管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Vehicle vehicle)
    {
        return toAjax(vehicleService.updateVehicle(vehicle));
    }

    /**
     * 删除车辆管理
     */
    @RequiresPermissions("system:vehicle:remove")
    @Log(title = "车辆管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(vehicleService.deleteVehicleByIds(ids));
    }
}
