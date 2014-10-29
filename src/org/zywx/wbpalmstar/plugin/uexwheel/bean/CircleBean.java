package org.zywx.wbpalmstar.plugin.uexwheel.bean;

import java.util.HashMap;
import java.util.List;

import android.graphics.Bitmap;

public class CircleBean {

    public final String BUTTON_TAG = "button";
    public final String MENUBG_TAG = "menuBg";
    public final String SUBMENUBG_TAG = "subMenuBg";
    public final String SELECTEDFIRSTMENUBG_TAG = "select_1";
    public final String SELECTEDMENUBG_TAG = "select_2";
    public final String DATA_TAG = "menu";
    public final String TABICON_TAG = "img";
    public final String ICONS_TAG = "subMenu";
    private Bitmap button;
    private Bitmap menuBg;
    private Bitmap subMenuBg;
    private Bitmap selectedFirstMenuBg;
    private Bitmap selectedMenuBg;
    private Bitmap[] tabs;
    private List<HashMap<String,Object>> data;
    
    public Bitmap[] getTabs() {
        return tabs;
    }
    public void setTabs(Bitmap[] tabs) {
        this.tabs = tabs;
    }

    public Bitmap getButton() {
        return button;
    }
    public void setButton(Bitmap button) {
        this.button = button;
    }
    public Bitmap getMenuBg() {
        return menuBg;
    }
    public void setMenuBg(Bitmap menuBg) {
        this.menuBg = menuBg;
    }
    public Bitmap getSubMenuBg() {
        return subMenuBg;
    }
    public void setSubMenuBg(Bitmap subMenuBg) {
        this.subMenuBg = subMenuBg;
    }
    public Bitmap getSelectedFirstMenuBg() {
        return selectedFirstMenuBg;
    }
    public void setSelectedFirstMenuBg(Bitmap selectedFirstMenuBg) {
        this.selectedFirstMenuBg = selectedFirstMenuBg;
    }
    public Bitmap getSelectedMenuBg() {
        return selectedMenuBg;
    }
    public void setSelectedMenuBg(Bitmap selectedMenuBg) {
        this.selectedMenuBg = selectedMenuBg;
    }
    public List<HashMap<String, Object>> getData() {
        return data;
    }
    public void setData(List<HashMap<String, Object>> data) {
        this.data = data;
    }
    public Bitmap getTabIcon(int index){
        return (Bitmap) this.data.get(index).get(TABICON_TAG);
    }
    public Bitmap[] getMenuIcons(int index){
        return (Bitmap[]) this.data.get(index).get(ICONS_TAG);
    }
}
