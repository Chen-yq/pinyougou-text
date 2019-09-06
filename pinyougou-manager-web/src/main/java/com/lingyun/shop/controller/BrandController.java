package com.lingyun.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lingyun.entity.PageResult;
import com.lingyun.entity.Result;
import com.lingyun.pojo.TbBrand;
import com.lingyun.pojo.TbContent;
import com.lingyun.pojo.TbContentCategory;
import com.lingyun.pojo.TbContentResult;
import com.lingyun.sellergoods.service.BrandService;

import com.lingyun.shop.util.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @类名: BrandController
 * @描述:
 * @作者: 陈耀强
 * @时间: 2019-09-02 16:05
 **/
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;



    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("/findContentCategory")
    public PageResult findContentCategory(TbContentCategory contentCategory,Integer page, Integer rows){
       if (page == null){
           page = 1;
       }
       if (rows == null){
           rows = 5;
       }
        return brandService.findContentCategory(contentCategory,rows,page);
    }

    @RequestMapping("/addContentCategory")
    public Result addContentCategory(TbContentCategory contentCategory){
        try {
            if(contentCategory.getId() != null){
                brandService.updateContentCategory(contentCategory);
            }else{
                brandService.addContentCategory(contentCategory);
            }
            return new Result(true,"新增成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"新增失败!");
    }

    @RequestMapping("/deleteContentCategory")
    public Result deleteContentCategory(Long id){
        try {
            brandService.deleteContentCategory(id);
            return new Result(true,"删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"删除失败!");
    }

    @RequestMapping("/removeContentCategory")
    public Result removeContentCategory(Long[] ids){
        try {
            brandService.removeContentCategory(ids);
            return new Result(true,"删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"删除失败!");
    }

    @RequestMapping("/findContentCategoryOne")
    public TbContentCategory findContentCategoryOne(Long id){
        return brandService.findContentCategoryOne(id);
    }

    @RequestMapping("/updateContentCategory")
    public Result updateContentCategory(TbContentCategory contentCategory){
        try {
            brandService.updateContentCategory(contentCategory);
            return new Result(true,"修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
          return new Result(false,"修改失败!");
    }

    @RequestMapping("/addContent")
    public Result addContent(TbContent content){
        try {
            brandService.addContent(content);
            return new Result(true,"新增成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false,"新增失败!");
    }

    @RequestMapping("/deleteContent")
    public Result deleteContent(Long id){
        try {
            brandService.deleteContent(id);
            return new Result(true,"删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(true,"删除失败!");
    }

    @RequestMapping("/removeContent")
    public Result removeContent(Long[] ids){
        try {
            brandService.removeContent(ids);
            return new Result(true,"删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(true,"删除失败!");
    }

    @RequestMapping("/findContentOne")
    public TbContent findContentOne(Long id){
        return brandService.findContentOne(id);
    }

    @RequestMapping("/updateContent")
    public Result updateContent(TbContent content){
        try {
            brandService.updateContent(content);
            return new Result(true,"修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(true,"修改失败!");
    }

    @RequestMapping("/findTbContentPage")
    public PageResult findTbContentPage(TbContent content ,@RequestParam(defaultValue = "5") Integer rows,@RequestParam(defaultValue = "1") Integer page){
       return brandService.findTbContentPage(content,rows,page);
    }

    @RequestMapping("findType")
    public List<TbContentCategory> findType(){
        return brandService.findType();
    }

    @RequestMapping("/upFile")
    public String upFile(MultipartFile file, HttpServletRequest request){
        String fileUpload = FileUtil.FileUpload(file, request);
        return fileUpload;
    }

    @RequestMapping("/findTbContent")
    public List<TbContent> findTbContent(){
        return brandService.findTbContent();
    }
}

