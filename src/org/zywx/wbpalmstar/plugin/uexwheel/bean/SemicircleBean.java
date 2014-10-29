package org.zywx.wbpalmstar.plugin.uexwheel.bean;

import java.util.List;

import android.graphics.Bitmap;

public class SemicircleBean {

    public final String DATA_TAG = "data";
    public final String TITLE_TAG = "title";
    public final String ICON_TAG = "image";
    public final String BGIMG_TAG = "background";
    
    private Bitmap bgImg;
    private List<UnitBean> data;
    public List<UnitBean> getData() {
        return data;
    }
    public void setData(List<UnitBean> data) {
        this.data = data;
    }
    public Bitmap getBgImg() {
        return bgImg;
    }
    public void setBgImg(Bitmap bgImg) {
        this.bgImg = bgImg;
    }
    public String getTitle(int index) {
        return getData().get(index).getTitle();
    }
    public Bitmap getIcon(int index) {
        return getData().get(index).getIcon();
    }
}
