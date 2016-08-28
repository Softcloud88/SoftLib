package com.softcloud.softlib.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.softcloud.softlib.R;
import com.softcloud.softlib.baseView.BaseFragment;
import com.softcloud.softlib.test.api.MovieService;
import com.softcloud.softlib.test.model.Top250MovieModel;
import com.softcloud.softlib.utils.ViewAccessor;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Softcloud on 16/8/28.
 */
public class ApiTestFragment extends BaseFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_api_test;
    }

    @Override
    protected void setupView(LayoutInflater inflater, View rootView, Bundle savedInstanceState) {
        getMovie();
    }


    private Retrofit getRetrofit(){
        String baseUrl = "https://api.douban.com/v2/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }


    private void getMovie() {
        MovieService movieService = getRetrofit().create(MovieService.class);
        movieService.getTopMovie(0, 2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Top250MovieModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Top250MovieModel top250MovieModel) {
                        ViewAccessor.create(rootView).setText(R.id.tv_test, top250MovieModel.getSubjects().get(0).getTitle());
                    }
                });
    }
}
