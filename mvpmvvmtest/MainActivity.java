package com.example.mvpmvvmtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class MainActivity extends AppCompatActivity  {
    Button btn1,btn2,btn3,btn4,btn5;
    TextView tvTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestViewModel testViewModel = new ViewModelProvider(this, new TestViewModelFactory("Helooooo!")).get(TestViewModel.class);


        testViewModel.testLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvTest.setText(s);
            }
        });

        tvTest = findViewById(R.id.tvTest);

        findViewById(R.id.button1).setOnClickListener(v->{
            testViewModel.setText("Something");
        });
        findViewById(R.id.button2).setOnClickListener(v->{

        });
        findViewById(R.id.button3).setOnClickListener(v->{

        });
        findViewById(R.id.button4).setOnClickListener(v->{

        });
        findViewById(R.id.button5).setOnClickListener(v->{

        });



    }


    class TestViewModelFactory extends ViewModelProvider.NewInstanceFactory{

        String message;

        public TestViewModelFactory(String message){
            this.message = message;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass == TestViewModel.class) {
                return (T) new TestViewModel(message);
            }
            return null;
        }
    }

}