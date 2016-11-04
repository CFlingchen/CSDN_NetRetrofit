package com.lingchen.netretrofit.net.model;

/**
 * Author    lingchen
 * Email     838878458@qq.com
 * Time      2016/11/4
 * Function  版本信息
 */

public class VersionModel {

    /**
     * versionName : 1.3.0
     * versionCode : 4
     * isQiangzhi : 1
     * url : http://bobo-sql.oss-cn-beijing.aliyuncs.com/app-bobo-release.apk
     * updateContent : 重要版本更新!
     */

    private String versionName;
    private int versionCode;
    private int isQiangzhi;
    private String url;
    private String updateContent;

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public int getIsQiangzhi() {
        return isQiangzhi;
    }

    public void setIsQiangzhi(int isQiangzhi) {
        this.isQiangzhi = isQiangzhi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

}
