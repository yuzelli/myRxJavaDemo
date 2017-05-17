package com.example.yuzelli.rxjavademo;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;


public class MainActivity extends Activity {
    final List<String> list = new ArrayList<>(Arrays.asList(new String[]{"aaaa","eeee","bbbb","cccc","bbbb"}));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.tv_begin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    observable.subscribe(observer);
            }
        });

    }

    Observable observable = Observable.create(new Observable.OnSubscribe<String>() {

        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("aaaa");
            subscriber.onNext("bbbb");
            subscriber.onNext("cccc");
            subscriber.onNext("dddd");
            subscriber.onNext("eeee");
            subscriber.onNext("fffff");
        }
    }).startWith(list);


    Observer<String> observer = new Observer<String>() {
        @Override
        public void onCompleted() {
            Log.d("--log-->","onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.d("--log-->",e.toString());
        }

        @Override
        public void onNext(String s) {
            Log.d("--log-->",s);
        }
    };


}
