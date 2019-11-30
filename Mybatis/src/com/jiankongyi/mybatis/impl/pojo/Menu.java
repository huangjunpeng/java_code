package com.jiankongyi.mybatis.impl.pojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Menu> lstMenu = null;
    private Integer id;
    private String name;
    private String icon;
    private String url;
    private Integer pid;

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
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                '}';
    }

    public void addSubMenu(Menu menu) {
        if (lstMenu == null) {
            lstMenu = new ArrayList<Menu>();
        }
        lstMenu.add(menu);
    }

    public void toJson(JSONArray jsonArray) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", getId());
        jsonObject.put("name", getName());
        jsonObject.put("icon", getIcon());
        jsonObject.put("url", getUrl());
        jsonObject.put("pid", getPid());
        if (lstMenu != null) {
            JSONArray jsonSubMenu = new JSONArray();
            for (Menu menu : lstMenu) {
                menu.toJson(jsonSubMenu);
            }
            jsonObject.put("submenu", jsonSubMenu);
        }
        jsonArray.add(jsonObject);
    }
}
