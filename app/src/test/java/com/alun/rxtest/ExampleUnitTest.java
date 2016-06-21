package com.alun.rxtest;

import android.provider.Settings;
import android.util.Log;

import org.junit.Test;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onNext(String s) {
                System.out.println("onNext"+s);
            }

            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable");
            }
        };

        Subscriber<String> subscriber=new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {

                System.out.println("onNext"+s);

            }
        } ;

        /*Observable observable =Observable.create(new Observable.OnSubscribe<String>(){

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("你好啊！！！");
                subscriber.onNext("你好啊2");
                subscriber.onCompleted();
            }
        });
*/
        Observable observable =Observable.just("1","2","3");
        String[] ss=new String[]{"1","2","3"};
        Observable observable1=Observable.from(ss);

        observable1.subscribe(subscriber);
    }
}