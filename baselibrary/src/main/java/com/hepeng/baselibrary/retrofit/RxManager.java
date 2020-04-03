package com.hepeng.baselibrary.retrofit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RxManager {

    /**
     * 请求失败重连次数
     */
    private int RETRY_COUNT = 0;

    public static RxManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final RxManager INSTANCE = new RxManager();
    }

    public ObservableTransformer schedulersTransformer() {
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable observable) {
                return observable.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    //处理请求结果 针对 有code message data 的json,对请求状态吗进行分析，如果成功获取result 中的data
    public <T> ObservableTransformer<HttpResult<T>, T> handleResult() {
        return new ObservableTransformer<HttpResult<T>, T>() {
            @Override
            public ObservableSource<T> apply(final Observable<HttpResult<T>> observable) {
                return observable.flatMap(new Function<HttpResult<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(HttpResult<T> tHttpResult) throws Exception {
                        if (tHttpResult.isSuccess()) {
                            return createSuccessData(tHttpResult.getResult());
                        } else {
                            return Observable.error(new Exception(tHttpResult.getMessage()));
                        }
                    }
                });
            }
        };
    }

    //创建成功返回的数据
    private <T> Observable<T> createSuccessData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter){
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }

    /**
     * 设置订阅 和 所在的线程环境
     */
    public <T> void toSubscribe(Observable<HttpResult<T>> o, DisposableObserver<T> s) {
        o.compose(schedulersTransformer())
                .compose(handleResult())
                .retry(RETRY_COUNT)//请求失败重连次数
                .subscribe(s);

    }

}
