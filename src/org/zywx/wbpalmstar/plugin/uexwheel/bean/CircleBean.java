package org.zywx.wbpalmstar.plugin.uexwheel.bean;

import java.util.HashMap;
import java.util.List;

import android.graphics.Bitmap;

public class CircleBean {

    public static final String BUTTON_TAG = "button";
    public static final String MENUBG_TAG = "menuBg";
    public static final String SUBMENUBG_TAG = "subMenuBg";
    public static final String ICON_LEFT_TAG = "iconLeft";
    public static final String ICON_SELECT_TAG = "iconSelect";
    public static final String BGCOLOR_TAG = "bgColor";
    public static final String DATA_TAG = "menu";
    public static final String TABICON_TAG = "img";
    public static final String ICONS_TAG = "subMenu";

    private Bitmap button;
    private Bitmap menuBg;
    private Bitmap subMenuBg;
    private Bitmap iconLeft;
    private Bitmap iconSelect;
    private Bitmap[] tabs;
    private String bgColor;
    private int type;
    private List<HashMap<String,Object>> data;
    
    public Bitmap[] getTabs() {
        return tabs;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public Bitmap getIconLeft() {
        return iconLeft;
    }
    public void setIconLeft(Bitmap iconLeft) {
        this.iconLeft = iconLeft;
    }
    public Bitmap getIconSelect() {
        return iconSelect;
    }
    public void setIconSelect(Bitmap iconSelect) {
        this.iconSelect = iconSelect;
    }
    public String getBgColor() {
        return bgColor;
    }
    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
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
