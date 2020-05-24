package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.NewsMapper;
import com.ruoyi.system.domain.News;
import com.ruoyi.system.service.INewsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-05-23
 */
@Service
public class NewsServiceImpl implements INewsService 
{
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public News selectNewsById(Long id)
    {
        return newsMapper.selectNewsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param news 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<News> selectNewsList(News news)
    {
        return newsMapper.selectNewsList(news);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param news 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertNews(News news)
    {
        return newsMapper.insertNews(news);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param news 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateNews(News news)
    {
        return newsMapper.updateNews(news);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewsByIds(String ids)
    {
        return newsMapper.deleteNewsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteNewsById(Long id)
    {
        return newsMapper.deleteNewsById(id);
    }
}
