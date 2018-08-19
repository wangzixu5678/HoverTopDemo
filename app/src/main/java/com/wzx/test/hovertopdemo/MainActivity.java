package com.wzx.test.hovertopdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyHoveringScrollView view_hover;
    private RecyclerView mRecyclerView;
    private TestAdapter mTestAdapter;
    private ArrayList<String> mDatas;
    private SmartRefreshLayout mSmartRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = LayoutInflater.from(this).inflate(R.layout.title, null);
        final Button btn = (Button) findViewById(R.id.btn);
        mSmartRefreshLayout = ((SmartRefreshLayout) findViewById(R.id.smartRefreshlayout));
        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                mSmartRefreshLayout.finishLoadMore(2000);
            }
        });
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mSmartRefreshLayout.finishRefresh(2000);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn.setBackgroundColor(Color.BLACK);
            }
        });
        view_hover = (MyHoveringScrollView) findViewById(R.id.view_hover);
        view_hover.setTopView(R.id.top);


        mDatas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mDatas.add("I love android " +i);
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTestAdapter = new TestAdapter(mDatas);
        mRecyclerView.setAdapter(mTestAdapter);
    }
}
