package com.lingyun.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @类名: PageResult
 * @描述:
 * @作者: 陈耀强
 * @时间: 2019-09-03 16:01
 **/
public class PageResult implements Serializable {
    private Long tool;
    private List rows;

    public PageResult() {
    }

    public PageResult(Long tool, List rows) {
        this.tool = tool;
        this.rows = rows;
    }


    public Long getTool() {
        return tool;
    }

    public void setTool(Long tool) {
        this.tool = tool;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "tool=" + tool +
                ", rows=" + rows +
                '}';
    }
}

