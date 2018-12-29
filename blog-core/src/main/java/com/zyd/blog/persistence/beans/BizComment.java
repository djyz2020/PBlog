package com.zyd.blog.persistence.beans;

import com.zyd.blog.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @website https://www.zhyd.me
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizComment extends AbstractDO {
    @Transient
    BizComment parent;
    @Transient
    BizArticle article;
    private Long userId;
    private Long sid;
    private Long pid;
    private String qq;
    private String nickname;
    private String avatar;
    private String email;
    private String url;
    private String status;
    private String ip;
    private String lng;
    private String lat;
    private String address;
    private String os;
    private String osShortName;
    private String browser;
    private String browserShortName;
    private String content;
    private String remark;
    private Integer support;
    private Integer oppose;

    public BizComment getParent() {
        return parent;
    }

    public void setParent(BizComment parent) {
        this.parent = parent;
    }

    public BizArticle getArticle() {
        return article;
    }

    public void setArticle(BizArticle article) {
        this.article = article;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOsShortName() {
        return osShortName;
    }

    public void setOsShortName(String osShortName) {
        this.osShortName = osShortName;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowserShortName() {
        return browserShortName;
    }

    public void setBrowserShortName(String browserShortName) {
        this.browserShortName = browserShortName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Integer getOppose() {
        return oppose;
    }

    public void setOppose(Integer oppose) {
        this.oppose = oppose;
    }
}
