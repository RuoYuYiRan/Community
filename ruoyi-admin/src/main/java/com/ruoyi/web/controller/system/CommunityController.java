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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * 前端显示
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

    @Autowired
    private  IBusinessGuideService businessGuideService;

    @GetMapping()
    public ModelAndView user()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("community/community");

        //查询类型为通知的公告  noticeType：1通知，2公告
        Integer noticeType = 1;
        Integer publishStatus = 1;//0：未发布公告 1：已发布公告
        List<SysNotice> noticeList = noticeService.selectNoticeByType(noticeType,publishStatus);
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
        Integer publishStatus = 1;//1：已发布通知 ，0：未发布通知
        List<SysNotice> list = noticeService.selectNoticeByType(noticeType,publishStatus);
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

    /**
     * 查询指南信息
     * @return
     */
    @Log(title = "指南", businessType = BusinessType.INSERT)
    @PostMapping("/selectLimitList")
    @ResponseBody
    public String selectLimitList( BusinessGuide businessGuide){
        List<BusinessGuide> guideList = businessGuideService.getGuideOrderByTime(businessGuide);
        return JSON.toJSONString(guideList);
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

    /**
     * 前台投诉信息查询
     * @return
     */
    @GetMapping("/complaint")
    public ModelAndView complaint(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("system/complaint/select");
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
     * 查询投诉列表
     */
    @PostMapping("/complaintList")
    @ResponseBody
    public TableDataInfo complaintList(Complaint complaint)
    {
        startPage();
        if(complaint == null) {
            System.out.println("123123");
        }
        List<Complaint> complaintList = complaintService.selectComplaintList(complaint);
        return getDataTable(complaintList);
    }

    /**
     * echart测试
     * @param model
     * @return
     */
    @RequestMapping(value = "/EcharsShow")
    @ResponseBody
    public List<Complaint> findById(Model model,Complaint complaint) {
        List<Complaint> list =  complaintService.selectComplaintList(complaint);
//        System.err.println(list.toString());
        return list;
    }
    @GetMapping(value = "/Echars.do")
    public String echarts4(Model model){
        System.err.println("========开始");
        return "main";
    }


}
