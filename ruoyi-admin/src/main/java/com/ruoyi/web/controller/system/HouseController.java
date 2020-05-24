package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.Building;
import com.ruoyi.system.domain.ResidentialQuarters;
import com.ruoyi.system.service.IBuildingService;
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
import com.ruoyi.system.domain.House;
import com.ruoyi.system.service.IHouseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

/**
 * 房屋管理Controller
 * 
 * @author yu
 * @date 2020-04-15
 */
@Controller
@RequestMapping("/system/house")
public class HouseController extends BaseController
{
    private String prefix = "system/house";

    @Autowired
    private IHouseService houseService;

    //小区
    @Autowired
    private IResidentialQuartersService residentialQuartersService;

    //楼宇
    @Autowired
    private IBuildingService buildingService;


    @RequiresPermissions("system:house:view")
    @GetMapping()
    public String house()
    {
        return prefix + "/house";
    }

    /**
     * 查询房屋管理列表
     */
    @RequiresPermissions("system:house:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(House house)
    {
        startPage();
        List<House> list = houseService.selectHouseList(house);
        return getDataTable(list);
    }

    /**
     * 导出房屋管理列表
     */
    @RequiresPermissions("system:house:export")
    @Log(title = "房屋管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(House house)
    {
        List<House> list = houseService.selectHouseList(house);
        ExcelUtil<House> util = new ExcelUtil<House>(House.class);
        return util.exportExcel(list, "house");
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
        //返回mav对象
        return mav;
    }

    /**
     * 新增保存房屋管理
     */
    @RequiresPermissions("system:house:add")
    @Log(title = "房屋管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(House house)
    {
        return toAjax(houseService.insertHouse(house));
    }

    /**
     * 修改房屋管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        House house = houseService.selectHouseById(id);
        mmap.put("house", house);
        return prefix + "/edit";
    }

    /**
     * 修改保存房屋管理
     */
    @RequiresPermissions("system:house:edit")
    @Log(title = "房屋管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(House house)
    {
        return toAjax(houseService.updateHouse(house));
    }

    /**
     * 删除房屋管理
     */
    @RequiresPermissions("system:house:remove")
    @Log(title = "房屋管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(houseService.deleteHouseByIds(ids));
    }
}
