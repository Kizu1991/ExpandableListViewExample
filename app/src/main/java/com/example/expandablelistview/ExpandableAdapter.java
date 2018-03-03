package com.example.expandablelistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.example.expandablelistview.databinding.RowBinding;
import com.example.expandablelistview.databinding.SectionRowBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter Class
 * Created by pdc-k-kamiya on 2018/03/03.
 */
public class ExpandableAdapter extends BaseExpandableListAdapter {

    private List<Section> mList;

    public ExpandableAdapter() {
        mList = new ArrayList<>();
    }

    public List<Section> getList() {
        return mList;
    }

    public void setList(List<Section> list) {
        mList = list;
    }

    @Override
    public int getGroupCount() {
        return mList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return getGroup(groupPosition).getRows().size();
    }

    @Override
    public Section getGroup(int groupPosition) {
        return mList.get(groupPosition);
    }

    @Override
    public Row getChild(int groupPosition, int childPosition) {
        return getGroup(groupPosition).getRows().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * Section表示のView
     *
     * @param groupPosition int
     * @param isExpanded    boolean 開いているかどうか
     * @param convertView   View
     * @param parent        ViewGroup
     * @return View
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        SectionRowBinding binding;
        if (convertView == null) {
            binding = SectionRowBinding.inflate(LayoutInflater.from(parent.getContext()));
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (SectionRowBinding) convertView.getTag();
        }

        binding.setModel(getGroup(groupPosition));

        return convertView;
    }

    /**
     * Section表示の中で表示するView
     *
     * @param groupPosition int
     * @param childPosition int
     * @param isLastChild   boolean グループ内の最後の子Viewかどうか
     * @param convertView   View
     * @param parent        ViewGroup
     * @return View
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        RowBinding binding;
        if (convertView == null) {
            binding = RowBinding.inflate(LayoutInflater.from(parent.getContext()));
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (RowBinding) convertView.getTag();
        }

        binding.setModel(getChild(groupPosition, childPosition));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // ここをtrueに設定しないと小ビューのClickが反応しない
        return true;
    }
}
