package com.softcloud.softlib.test.data;

/**
 * Created by Softcloud on 16/8/28.
 */
public class Image extends BaseData {
    private String small;
    private String large;
    private String medium;

    public String getSmall() {
        return small != null ? small : "";
    }

    public String getLarge() {
        return large != null ? large : "";
    }

    public String getMedium() {
        return medium != null ? medium : "";
    }
}
