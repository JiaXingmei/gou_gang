package com.example.myhome.model.model;

import com.example.myhome.model.presenter.HomeListPresenter;
import com.example.network.MyTask;

public class HomeListModelnter implements IHomeListModelnter {
    MOduleInterface mOduleInterface;
    public HomeListModelnter(MOduleInterface mOduleInterface) {
        this.mOduleInterface = mOduleInterface;
    }

    @Override
    public void getDate(final String url) {
        new Runnable() {
            @Override
            public void run() {
                new MyTask<String>(url,"GET").setTaskListener(new MyTask.TaskListeners() {
                    @Override
                    public void result(String t) {
                        if (t != null){
                            mOduleInterface.LoadSuccess(t);
                        } else {
                            mOduleInterface.LoadFailed();
                        }
                    }
                }).execute();
            }
        }.run();
    }

    public interface MOduleInterface{
        //获取数据状态回调的接口
        void LoadSuccess(String data);
        void LoadFailed();
    }
}
