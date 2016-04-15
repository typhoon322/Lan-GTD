package com.androidapp.yanx.lan_gtd;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * com.androidapp.yanx.lan_gtd
 * Created by yanx on 4/14/16 11:48 AM.
 * Description ${TODO}
 */
public class CraftClass {
    private static final String TAG = "CraftClass";
    private Context mContext;
    public Observable<Integer> myObservable = Observable.just("Hello,World!~~~").map(new Func1<String, Integer>() {
        @Override
        public Integer call(String s) {
            return s.hashCode();
        }
    }) ;
    public Action1<Integer> onNextAction = new Action1<Integer>() {
        @Override
        public void call(Integer s) {
            Log.i(TAG, "call: "+s);
            Toast.makeText(mContext, String.valueOf(s), Toast.LENGTH_SHORT).show();

        }
    };

    public Subscriber<String> mySubscriber = new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {
            Log.i(TAG, "onNext: " + s);
            Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();
        }
    };

    public CraftClass(Context ctx) {
        mContext = ctx;
    }

}
