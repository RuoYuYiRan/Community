package com.ruoyi.web.controller.system;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
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
import com.ruoyi.system.domain.BusinessGuide;
import com.ruoyi.system.service.IBusinessGuideService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.servlet.ModelAndView;

/**
 * 办事指南Controller
 * 
 * @author yu
 * @date 2020-04-15
 */
@Controller
@RequestMapping("/system/guide")
public class BusinessGuideController extends BaseController
{
    private String prefix = "system/guide";

    @Autowired
    private IBusinessGuideService businessGuideService;

    @RequiresPermissions("system:guide:view")
    @GetMapping()
    public ModelAndView guide()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(prefix + "/guide");
        List<BusinessGuide> list = businessGuideService.selectBusinessGuideList(null);
        mav.addObject("list", list.get(0));
        return mav;
    }

    /**
     * 查询办事指南列表
     */
    @RequiresPermissions("system:guide:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BusinessGuide businessGuide)
    {
        startPage();
        List<BusinessGuide> list = businessGuideService.selectBusinessGuideList(businessGuide);
        return getDataTable(list);
    }

    /**
     * 导出办事指南列表
     */
    @RequiresPermissions("system:guide:export")
    @Log(title = "办事指南", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BusinessGuide businessGuide)
    {
        List<BusinessGuide> list = businessGuideService.selectBusinessGuideList(businessGuide);
        ExcelUtil<BusinessGuide> util = new ExcelUtil<BusinessGuide>(BusinessGuide.class);
        return util.exportExcel(list, "guide");
    }

    /**
     * 新增办事指南
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存办事指南
     */
    @RequiresPermissions("system:guide:add")
    @Log(title = "办事指南", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BusinessGuide businessGuide)
    {
        businessGuide.setCreateDate(new Date());
        //设置不启用
        businessGuide.setIsStart("0");
        return toAjax(businessGuideService.insertBusinessGuide(businessGuide));
    }

    /**
     * 修改办事指南
     */
    @GetMapping("//edit/{id}")
    public String edit( @PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("businessGuide", businessGuideService.selectBusinessGuideById(id));
        return prefix + "/edit";
    }

    /**
     * 修改保存办事指南
     */
    @RequiresPermissions("system:guide:edit")
    @Log(title = "办事指南", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BusinessGuide businessGuide)
    {
        return toAjax(businessGuideService.updateBusinessGuide(businessGuide));
    }

    /**
     * 删除办事指南
     */
    @RequiresPermissions("system:guide:remove")
    @Log(title = "办事指南", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(businessGuideService.deleteBusinessGuideByIds(ids));
    }

    @PostMapping("/getBusinessGuide")
    @ResponseBody
    public String getBusinessGuide(){
        BusinessGuide businessGuide = businessGuideService.selectBusinessGuideList(null).get(0);
        return JSON.toJSONString(businessGuide);
    }
}
