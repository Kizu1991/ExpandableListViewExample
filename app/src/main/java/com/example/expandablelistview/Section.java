package com.example.expandablelistview;

import java.util.ArrayList;
import java.util.List;

/**
 * Sectionに表示するデータ
 * Created by pdc-k-kamiya on 2018/03/03.
 */

public class Section {
    private String mSectionText;
    private List<Row> mRows;

    public Section() {
        mSectionText = "";
        mRows = new ArrayList<>();
    }

    public String getSectionText() {
        return mSectionText;
    }

    public void setSectionText(String sectionText) {
        mSectionText = sectionText;
    }

    public List<Row> getRows() {
        return mRows;
    }

    public void setRows(List<Row> rows) {
        mRows = rows;
    }
}
