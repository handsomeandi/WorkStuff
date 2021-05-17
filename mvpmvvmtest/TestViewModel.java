package com.example.mvpmvvmtest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {
    private MutableLiveData<String> testLiveDataa = new MutableLiveData<>();
    public LiveData<String> testLiveData = testLiveDataa;


    public TestViewModel(String message){
        testLiveDataa.postValue(message);
    }

    void setText(String message){
        testLiveDataa.postValue(message);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }
}
