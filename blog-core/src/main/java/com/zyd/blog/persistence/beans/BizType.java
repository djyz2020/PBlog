package com.zyd.blog.persistence.beans;

import com.zyd.blog.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.util.List;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizType extends AbstractDO {
    private Long pid;
    private String name;
    private String description;
    private Integer sort;
    private Boolean available;
    private String icon;
    @Transient
    private BizType parent;
    @Transient
    private List<BizType> nodes;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public BizType getParent() {
        return parent;
    }

    public void setParent(BizType parent) {
        this.parent = parent;
    }

    public List<BizType> getNodes() {
        return nodes;
    }

    public void setNodes(List<BizType> nodes) {
        this.nodes = nodes;
    }
}
