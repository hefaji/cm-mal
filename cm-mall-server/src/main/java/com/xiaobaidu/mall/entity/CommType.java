package com.xiaobaidu.mall.entity;

import java.util.List;

public class CommType {

    private String id;

    private CommType parent;

    private String name;

    private Integer hot;

    private String image;

    private Integer pos;

    private List<CommType> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CommType getParent() {
        return parent;
    }

    public void setParent(CommType parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CommType> getChildren() {
        return children;
    }

    public void setChildren(List<CommType> children) {
        this.children = children;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }
}