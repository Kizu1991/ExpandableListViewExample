package com.example.expandablelistview;

/**
 * Row に表示するデータ
 * Created by pdc-k-kamiya on 2018/03/03.
 */
public class Row {
    private String mRowText;

    public Row() {
        mRowText = "";
    }

    public String getRowText() {
        return mRowText;
    }

    public void setRowText(String rowText) {
        mRowText = rowText;
    }
}
