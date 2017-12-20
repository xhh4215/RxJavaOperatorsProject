package com.example.xhh.rxjavaoperatorsproject;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;


public class NewActivity extends AppCompatActivity {
    public String TAG = "NewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
//        Single.just(2)
//                .subscribe(new SingleObserver<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Toast.makeText(NewActivity.this, "结束订阅的关系", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onSuccess(Integer value) {
//                        Toast.makeText(NewActivity.this, "操作成功", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Toast.makeText(NewActivity.this, "操作失败", Toast.LENGTH_SHORT).show();
//                    }
//                });
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                emitter.onNext("小黑"); // skip
//                Thread.sleep(400);
//                emitter.onNext("小黑黑"); // deliver
//                Thread.sleep(505);
//                emitter.onNext("小黑黑黑"); // skip
//                Thread.sleep(100);
//                emitter.onNext("小黑黑嘿嘿"); // deliver
//                Thread.sleep(605);
//                emitter.onNext("是的是小黑"); // deliver
//                Thread.sleep(510);
//                emitter.onComplete();
//            }
//        }).debounce(300, TimeUnit.MILLISECONDS)
//                .subscribe(
//                        new Consumer<String>() {
//                            @Override
//                            public void accept(String s) throws Exception {
//                                Toast.makeText(NewActivity.this, ""+s, Toast.LENGTH_SHORT).show();
//                                Log.d(TAG, "accept: "+s);
//                            }
//                        }
//
//                );
        Observable.just(1,2,3)
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer2-integer;
                    }
                })
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "accept: "+integer);
                    }
                });
    }
}
