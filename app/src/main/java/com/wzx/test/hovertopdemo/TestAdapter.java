package com.wzx.test.hovertopdemo;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by wzx on 2018/8/19.
 */

public class TestAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public TestAdapter(@Nullable List<String> data) {
        super(android.R.layout.simple_list_item_1, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(android.R.id.text1,item);
    }
}
