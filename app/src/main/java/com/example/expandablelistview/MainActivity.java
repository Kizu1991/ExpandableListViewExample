package com.example.expandablelistview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.expandablelistview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener{

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ExpandableAdapter adapter = new ExpandableAdapter();
        adapter.setList(createItem());
        mBinding.expandableListview.setAdapter(adapter);
        mBinding.expandableListview.setOnGroupClickListener(this);
        mBinding.expandableListview.setOnChildClickListener(this);

        // 初期表示をリスト展開した状態に設定
        for(int i = 0; i < mBinding.expandableListview.getExpandableListAdapter().getGroupCount(); i++){
            mBinding.expandableListview.expandGroup(i);
        }
    }

    /**
     * Listの表示を行う為のデータ作成処理
     * このメソッドの場合
     * 全部で10セクション
     * 1セクションに5個
     *
     * @return List
     */
    public List<Section> createItem() {
        List<Section> items = new ArrayList<>();
        // Sectionの数ループを回す
        for (int i = 0; i < 10; i++) {
            Section section = new Section();
            section.setSectionText(String.format(Locale.getDefault(), "Section = %d", i));
            List<Row> rows = section.getRows();

            // Sectionの中に表示する子データ
            for (int j = 0; j < 5; j++) {
                Row row = new Row();
                row.setRowText(String.format(Locale.getDefault(), "Section = %d Row = %d", i, j));
                rows.add(row);
            }
            items.add(section);
        }
        return items;
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Toast.makeText(this, String.format(Locale.getDefault(), "Section = %d Row = %d", groupPosition, childPosition), Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        Toast.makeText(this, String.format(Locale.getDefault(), "Section = %d", groupPosition), Toast.LENGTH_SHORT).show();
        // return trueで折りたたまれなくなる、falseで折りたたまれる
        return true;
    }
}
