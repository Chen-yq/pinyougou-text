package com.lingyun.sellergoods.service;

import com.lingyun.entity.PageResult;
import com.lingyun.pojo.TbBrand;
import com.lingyun.pojo.TbContent;
import com.lingyun.pojo.TbContentCategory;
import com.lingyun.pojo.TbContentResult;

import java.util.List;

public interface BrandService {

    public List<TbBrand> findAll();

    public PageResult findContentCategory(TbContentCategory contentCategory,Integer rows,Integer page);

    public void addContentCategory(TbContentCategory contentCategory);

    public void deleteContentCategory(Long id);

    public void removeContentCategory(Long[] ids);

    public TbContentCategory findContentCategoryOne(Long id);

    public void updateContentCategory(TbContentCategory contentCategory);

    public void addContent(TbContent content);

    public void deleteContent(Long id);

    public void removeContent(Long[] ids);

    public TbContent findContentOne(Long id);

    public void updateContent(TbContent content);

    public PageResult findTbContentPage(TbContent content,Integer rows, Integer page);

    List<TbContentCategory> findType();

    List<TbContent> findTbContent();
}
