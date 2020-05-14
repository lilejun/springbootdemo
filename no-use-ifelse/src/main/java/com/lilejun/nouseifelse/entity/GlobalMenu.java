package com.lilejun.nouseifelse.entity;

import java.util.ArrayList;
import java.util.List;

public class GlobalMenu {
    private String name;

    private String link;

    private List<GlobalMenu> subMenus = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<GlobalMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<GlobalMenu> subMenus) {
        this.subMenus = subMenus;
    }
}
