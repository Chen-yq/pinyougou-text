package com.lingyun.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lingyun.entity.PageResult;
import com.lingyun.mapper.TbBrandMapper;
import com.lingyun.mapper.TbContentCategoryMapper;
import com.lingyun.mapper.TbContentMapper;
import com.lingyun.pojo.*;
import com.lingyun.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名: BrandServiceImpl
 * @描述:
 * @作者: 陈耀强
 * @时间: 2019-09-02 15:51
 **/
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Autowired
    private TbContentMapper tbContentMapper;

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public PageResult findContentCategory(TbContentCategory contentCategory,Integer rows,Integer page) {
        PageHelper.startPage(page,rows);
        TbContentCategoryExample contentTypeExampleExample = new TbContentCategoryExample();
        TbContentCategoryExample.Criteria criteria = contentTypeExampleExample.createCriteria();
        if(contentCategory!=null){
            if(contentCategory.getName()!=null && contentCategory.getName() !=""){
                criteria.andNameLike("%"+contentCategory.getName()+"%");
            }
        }
        Page<TbContentCategory> contentTypes = (Page<TbContentCategory>) tbContentCategoryMapper.selectByExample(contentTypeExampleExample);
        return new PageResult(contentTypes.getTotal(), contentTypes.getResult());
    }

    @Override
    public void addContentCategory(TbContentCategory contentCategory) {
        tbContentCategoryMapper.insert(contentCategory);
    }

    @Override
    public void deleteContentCategory(Long id) {
       tbContentCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeContentCategory(Long[] ids) {
        for (Long id:ids) {
            tbContentCategoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public TbContentCategory findContentCategoryOne(Long id) {
        return tbContentCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateContentCategory(TbContentCategory contentCategory) {
        tbContentCategoryMapper.updateByPrimaryKey(contentCategory);
    }

    @Override
    public void addContent(TbContent content) {
        tbContentMapper.insert(content);
    }

    @Override
    public void deleteContent(Long id) {
      tbContentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void removeContent(Long[] ids) {
        for (Long id:ids) {
            tbContentMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public TbContent findContentOne(Long id) {
        return tbContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateContent(TbContent content) {
      tbContentMapper.updateByPrimaryKey(content);
    }


    public PageResult findTbContentPage(TbContent content,Integer rows, Integer page) {
        PageHelper.startPage(page,rows);
        TbContentExample contentExample = new TbContentExample();
        TbContentExample.Criteria criteria = contentExample.createCriteria();
        if(content!=null){
            if(content.getTitle()!=null && content.getTitle() !=""){
                criteria.andTitleLike("%"+content.getTitle()+"%");
            }
        }
        Page<TbContent> contents1 = (Page<TbContent>) tbContentMapper.selectByExample(contentExample);
        Page<TbContentResult> contentAndTypeExaples = new Page<>();
        contentAndTypeExaples.setTotal(contents1.getTotal());
        for (TbContent content1 : contents1){
            TbContentResult contentResult = new TbContentResult();
            contentResult.setTbContent(content1);
            TbContentCategory contentType = tbContentCategoryMapper.selectByPrimaryKey(content1.getCategoryId());
            contentResult.setTbContentCategory(contentType);
            contentAndTypeExaples.add(contentResult);
        }
        return new PageResult(contentAndTypeExaples.getTotal(),contentAndTypeExaples.getResult());
    }

    @Override
    public List<TbContentCategory> findType() {
        return tbContentCategoryMapper.selectByExample(null);
    }

    @Override
    public List<TbContent> findTbContent() {
        return tbContentMapper.selectByExample(null);
    }


}

