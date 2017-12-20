package com.example.xhh.rxjavaoperatorsproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/***
 * 这是一个关于RxJava中的create操作符的使用的练习
 * @author 栾桂明
 */

public class CreateActivity extends AppCompatActivity {
    private String TAG = "CreateActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        /**
         *  @创建被观察者
         *  @method: 当被观察者被订阅的时候回调的方法
         */
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            /**
             *
             * @param e  被观察者发送数据的对象
             * @throws Exception  可能发生的异常
             */
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("小黑");
                e.onNext("小黑黑");
//                e.onComplete();
            }
        });
        Observable<String> observable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("111111");
                e.onNext("222222");
            }
        });
        /**
         * @创建观察者
         * @method 处理被观察者发射的数据
         */
        Observer<String> observer = new Observer<String>() {
            /**
             * 处理数据之前的准备操作的方法
             * @param d 一个用来切断订阅关系的对象
             */
            @Override
            public void onSubscribe(Disposable d) {

            }

            /**
             * 处理OnNext()发射的数据
             * @param value
             */
            @Override
            public void onNext(String value) {
                Log.d(TAG, "onNext: " + value);
            }

            /***
             * 处理发射出错的逻辑
             * @param e 保存了错误信息的对象
             */
            @Override
            public void onError(Throwable e) {

            }

            /***
             * 处理发射出完成的逻辑
             */
            @Override
            public void onComplete() {

            }
        };
//        观察者订阅被观察者
        observable
                .concat(observable,observable1)
//                用来指定subscribe()发生的线程
                .subscribeOn(Schedulers.newThread())
//                指定下游的回调发生的线程
                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(String s) throws Exception {
//                        return "被转化的字符串为"+s;
//                    }
//                })
                .subscribe(observer);
    }
}
