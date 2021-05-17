package com.example.mvpmvvmtest;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class TestPresenter extends MvpPresenter<ITestView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showHelloWorld("Hello world From Presenter");
    }

    @Override
    public void attachView(ITestView view) {
        super.attachView(view);
    }

    @Override
    public void detachView(ITestView view) {
        super.detachView(view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
