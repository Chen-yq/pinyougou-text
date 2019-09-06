package com.lingyun.pojo;

import java.io.Serializable;

/**
 * @类名: TbContentResult
 * @描述:
 * @作者: 陈耀强
 * @时间: 2019-09-03 21:20
 **/
public class TbContentResult implements Serializable {
     private TbContent tbContent;
     private TbContentCategory tbContentCategory;

    public TbContentResult() {
    }

    public TbContentResult(TbContent tbContent, TbContentCategory tbContentCategory) {
        this.tbContent = tbContent;
        this.tbContentCategory = tbContentCategory;
    }

    public TbContent getTbContent() {
        return tbContent;
    }

    public void setTbContent(TbContent tbContent) {
        this.tbContent = tbContent;
    }

    public TbContentCategory getTbContentCategory() {
        return tbContentCategory;
    }

    public void setTbContentCategory(TbContentCategory tbContentCategory) {
        this.tbContentCategory = tbContentCategory;
    }

    @Override
    public String toString() {
        return "TbContentResult{" +
                "tbContent=" + tbContent +
                ", tbContentCategory=" + tbContentCategory +
                '}';
    }
}

