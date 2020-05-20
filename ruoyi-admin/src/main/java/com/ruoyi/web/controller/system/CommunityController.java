package com.ruoyi.web.controller.system;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * 前太显示
 */
@Controller
@RequestMapping("/community")
public class CommunityController extends BaseController {

    @Autowired
    private ISysNoticeService noticeService;

    @Autowired
    private IResidentialQuartersService residentialQuartersService;

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IHouseService houseService;

    @Autowired
    private IWarrantyService warrantyService;

    @Autowired
    private IComplaintService complaintService;

    @GetMapping()
    public ModelAndView user()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("community/community");

        //查询类型为通知的公告  noticeType：1通知，2公告
        Integer noticeType = 1;
        List<SysNotice> noticeList = noticeService.selectNoticeByType(noticeType);
        mav.addObject("noticeList", noticeList);

        //查询小区
        List<ResidentialQuarters> residentialQuartersList = residentialQuartersService.selectCellIdAndCellName();
        mav.addObject("residentialQuartersList", residentialQuartersList);

        //查询楼宇
        List<Building> buildingList  = buildingService.selectIdAndBuildName();
        mav.addObject("buildingList", buildingList);
        //查询房屋
        List<House> houseList = houseService.selectIdAndUnitNum();
        mav.addObject("houseList", houseList);

        return mav;
    }

    /**
     * 公告
     * @return
     */
    @PostMapping("/noticeList")
    @ResponseBody
    public String noticeList(){
        //查询类型为通知的公告  noticeType：1通知，2公告
        Integer noticeType = 2;
        List<SysNotice> list = noticeService.selectNoticeByType(noticeType);
        return JSON.toJSONString(list);
    }

    /**
     * 新增保存办事指南
     */
    @Log(title = "保修", businessType = BusinessType.INSERT)
    @PostMapping("/addWarranty")
    @ResponseBody
    public String addWarranty(Warranty warranty)
    {
        warranty.setCreateTime(new Date());
        warranty.setStatus("0");
        int i = warrantyService.insertWarranty(warranty);
        return "success";
    }

    /**
     * 新增保存办事指南
     */
    @Log(title = "投诉", businessType = BusinessType.INSERT)
    @PostMapping("/addComplaint")
    @ResponseBody
    public String addComplaint(Complaint complaint)
    {
        complaint.setCreateTime(new Date());
        complaint.setStatus("0");
        int i = complaintService.insertComplaint(complaint);
        return "success";
    }

    @GetMapping("/warranty")
    public ModelAndView warranty(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("system/warranty/select");
        //查询小区
        List<ResidentialQuarters> residentialQuartersList = residentialQuartersService.selectCellIdAndCellName();
        mav.addObject("residentialQuartersList", residentialQuartersList);

        //查询楼宇
        List<Building> buildingList  = buildingService.selectIdAndBuildName();
        mav.addObject("buildingList", buildingList);
        //查询房屋
        List<House> houseList = houseService.selectIdAndUnitNum();
        mav.addObject("houseList", houseList);
        return mav;
    }
    /**
     * 查询保修列表
     */
    @PostMapping("/warrantyList")
    @ResponseBody
    public TableDataInfo warrantyList(Warranty warranty)
    {
        startPage();
        if(warranty == null) {
            System.out.println("123123");
        }
        List<Warranty> list = warrantyService.selectWarrantyList(warranty);
        return getDataTable(list);
    }

}
