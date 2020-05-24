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
import com.ruoyi.system.domain.News;
import com.ruoyi.system.service.INewsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【消息Controller
 * 
 * @author ruoyi
 * @date 2020-05-23
 */
@Controller
@RequestMapping("/system/news")
public class NewsController extends BaseController
{
    private String prefix = "system/news";

    @Autowired
    private INewsService newsService;

    @RequiresPermissions("system:news:view")
    @GetMapping()
    public String news()
    {
        return prefix + "/news";
    }

    /**
     * 查询消息列表
     */
    @RequiresPermissions("system:news:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(News news)
    {
        startPage();
        List<News> list = newsService.selectNewsList(news);
        return getDataTable(list);
    }

    /**
     * 导出消息列表
     */
    @RequiresPermissions("system:news:export")
    @Log(title = "", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(News news)
    {
        List<News> list = newsService.selectNewsList(news);
        ExcelUtil<News> util = new ExcelUtil<News>(News.class);
        return util.exportExcel(list, "news");
    }

//    /**
//     * 新增
//     */
//    @GetMapping("/add")
//    public String add()
//    {
//        return prefix + "/add";
//    }

    /**
     * 新增保存
     */

    @Log(title = "上报", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(News news)
    {
        return toAjax(newsService.insertNews(news));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        News news = newsService.selectNewsById(id);
        mmap.put("news", news);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:news:edit")
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(News news)
    {
        return toAjax(newsService.updateNews(news));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:news:remove")
    @Log(title = "删除", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(newsService.deleteNewsByIds(ids));
    }
}
