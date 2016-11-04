package com.lingchen.netretrofit;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Rxjava1.x
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("凌晨");
                e.onNext("是");
                e.onNext("大佬");
                e.onError(new Throwable("给大佬低头"));
            }
        }).onErrorResumeNext(Observable.<String>empty()).subscribe();

        //Rxjava2.x
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("凌晨");
                e.onNext("是");
                e.onNext("大佬");
                e.onError(new Throwable("给大佬低头"));
            }
        }, BackpressureStrategy.BUFFER).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept() called with: s = [" + s + "]");
            }
        }).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, "accept() called with: throwable = [" + throwable.getMessage() + "]");
            }
        }).onErrorResumeNext(Flowable.<String>empty()).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.e(TAG, "accept() called with: s = [" + s + "]");
            }
        });
        Flowable.just(R.mipmap.ic_launcher)
                .map(new Function<Integer, Bitmap>() {

                    @Override
                    public Bitmap apply(Integer integer) throws Exception {
                        return BitmapFactory.decodeResource(getResources(), integer);
                    }
                }).filter(new Predicate<Bitmap>() {
            @Override
            public boolean test(Bitmap bitmap) throws Exception {
                return bitmap != null;
            }
        }).doOnNext(new Consumer<Bitmap>() {
            @Override
            public void accept(Bitmap bitmap) throws Exception {
                Log.e(TAG, "accept() called with: bitmap = [" + bitmap.getWidth() + "]");
            }
        }).onErrorResumeNext(Flowable.<Bitmap>empty())
                .subscribe();
    }
}
