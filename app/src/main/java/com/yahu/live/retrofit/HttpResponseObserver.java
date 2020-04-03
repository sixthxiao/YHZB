package com.yahu.live.retrofit;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class HttpResponseObserver<T> implements Observer<HttpResponse<T>> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(HttpResponse<T> t) {
        if (t.getCode() == 0) {
            onSuccess(t);
        } else {
            onFail(t);
        }
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(HttpResponse<T> response);

    public abstract void onFail(HttpResponse<T> response);
}
