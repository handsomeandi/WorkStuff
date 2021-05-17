package com.example.mvpmvvmtest;

import moxy.MvpView;
import moxy.viewstate.strategy.SingleStateStrategy;
import moxy.viewstate.strategy.SkipStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface ITestView extends MvpView {

    @StateStrategyType(SingleStateStrategy.class)
    void showHelloWorld(String message);

    @StateStrategyType(SkipStrategy.class)
    void showMessageToast(String message);

}
