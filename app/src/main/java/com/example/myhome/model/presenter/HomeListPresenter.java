package com.example.myhome.model.presenter;

import android.util.Log;

import com.example.api.Api;
import com.example.day02_test.MainActivity;
import com.example.myhome.model.model.HomeListModelnter;

public class HomeListPresenter implements IHomeListPresenter,HomeListModelnter.MOduleInterface{


    private final HomeListModelnter homeListModelnter;
    MainActivity mainActivity;
    private String modeInterDate;

    //构造器
    public HomeListPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        //初始化model
        homeListModelnter = new HomeListModelnter(this);
    }

    @Override
    public void getModelDate() {
        //回调model
        homeListModelnter.getDate(Api.SHOPLIST);
    }

    public void LoadSuccess(String data){
        mainActivity.getViewData(data);
    }

    public void LoadFailed(){
        mainActivity.getViewData("加载失败");
    }
}
