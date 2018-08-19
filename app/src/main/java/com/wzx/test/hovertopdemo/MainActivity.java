package com.wzx.test.hovertopdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyHoveringScrollView view_hover;
    private RecyclerView mRecyclerView;
    private TestAdapter mTestAdapter;
    private ArrayList<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn = (Button) findViewById(R.id.btn);
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
