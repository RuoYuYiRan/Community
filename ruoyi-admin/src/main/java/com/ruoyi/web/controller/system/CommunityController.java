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
        String result = "成功！！！";
        //判断是否有该居民
        int temp = houseService.queryHouseByInfo(warranty.getTellPhone(),warranty.getHouseId(),warranty.getBuildId(),warranty.getCellId());
        if(temp==1) {
            warranty.setCreateTime(new Date());
            warranty.setStatus("0");
            int i = warrantyService.insertWarranty(warranty);
            if(i==0) {
                result="添加失败，请联系管理员";
            }
        }else {
            result="社区没有该居民，请核实填写信息或联系管理员";
        }

        return result;
    }

    /**
     * 新增保存办事指南
     */
    @Log(title = "投诉", businessType = BusinessType.INSERT)
    @PostMapping("/addComplaint")
    @ResponseBody
    public String addComplaint(Complaint complaint)
    {
        String result = "成功！！！";
        //判断是否有该居民
        int temp = houseService.queryHouseByInfo(complaint.getTellPhone(),complaint.getHouseId(),complaint.getBuildId(),complaint.getCellId());
        if(temp==1) {
            complaint.setCreateTime(new Date());
            complaint.setStatus("0");
            int i = complaintService.insertComplaint(complaint);
            if(i==0) {
                result="添加失败，请联系管理员";
            }
        }else {
            result="社区没有该居民，请核实填写信息或联系管理员";
        }

        return result;
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
     * 楼宇下的单元数据统计
     * @return
     */
    @RequestMapping(value = "/EcharsShow")
    @ResponseBody
    public List<Building> findComplaintStatus(Building building) {
        List<Building> list = buildingService.selectBuildingList(building);
        System.err.println(list.toString());
        return list;
    }

    @RequestMapping(value = "/getUnit")
    @ResponseBody
    public String getUnit(){
        List<House> houseList = houseService.selectIdAndUnitNum();
        return JSON.toJSONString(houseList);
    }

}
