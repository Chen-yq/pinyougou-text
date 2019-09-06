package com.lingyun.pojo;

import java.io.Serializable;

public class TbBrand implements Serializable {
    private Integer id;

    private String name;

    private String firstchar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFirstchar() {
        return firstchar;
    }

    public void setFirstchar(String firstchar) {
        this.firstchar = firstchar == null ? null : firstchar.trim();
    }
}