package org.zywx.wbpalmstar.plugin.uexwheel.bean;

import java.util.List;

import android.graphics.Bitmap;

public class QuartercircleBean {

    public static final String DATA_TAG = "data";
    public static final String TITLE_TAG = "title";
    public static final String ICON_TAG = "image";
    public static final String OPENIMG_TAG = "openImg";
    public static final String CLOSEIMG_TAG = "closeImg";
    public static final String ROOTBG_TAG = "rootBg";
    public static final String SUBBG_TAG = "subBg";
    public static final String OPENTITLE_TAG = "openTitle";
    public static final String CLOSETITLE_TAG = "closeTitle";
    public static final String TEXTCOLOR_TAG = "textColor";

    private Bitmap openImg;
    private Bitmap closeImg;
    private Bitmap rootBg;
    private Bitmap subBg;
    private String openTitle;
    private String closeTitle;
    private String textColor;
    public String getTextColor() {
        return textColor;
    }
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
    private List<UnitBean> data;
    public List<UnitBean> getData() {
        return data;
    }
    public void setData(List<UnitBean> data) {
        this.data = data;
    }
    public String getTitle(int index) {
        return data.get(index).getTitle();
    }
    public Bitmap getIcon(int index) {
        return data.get(index).getIcon();
    }
    public Bitmap getOpenImg() {
        return openImg;
    }
    public void setOpenImg(Bitmap openImg) {
        this.openImg = openImg;
    }
    public Bitmap getCloseImg() {
        return closeImg;
    }
    public void setCloseImg(Bitmap closeImg) {
        this.closeImg = closeImg;
    }
    public Bitmap getRootBg() {
        return rootBg;
    }
    public void setRootBg(Bitmap rootBg) {
        this.rootBg = rootBg;
    }
    public Bitmap getSubBg() {
        return subBg;
    }
    public void setSubBg(Bitmap subBg) {
        this.subBg = subBg;
    }
    public String getOpenTitle() {
        return openTitle;
    }
    public void setOpenTitle(String openTitle) {
        this.openTitle = openTitle;
    }
    public String getCloseTitle() {
        return closeTitle;
    }
    public void setCloseTitle(String closeTitle) {
        this.closeTitle = closeTitle;
    }
       
     
}
