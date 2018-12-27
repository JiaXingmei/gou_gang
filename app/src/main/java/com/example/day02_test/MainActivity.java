package com.example.day02_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myhome.model.presenter.HomeListPresenter;
import com.example.myhome.view.IHomeListView;

public class MainActivity extends AppCompatActivity implements IHomeListView {

    private TextView text_helloworld;
    private HomeListPresenter homeListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        text_helloworld = findViewById(R.id.text_helloworld);
        //初始化presenter
        homeListPresenter = new HomeListPresenter(this);
        homeListPresenter.getModelDate();
    }

    @Override
    public void getViewData(String viewDate) {
        text_helloworld.setText(viewDate);
    }
}
