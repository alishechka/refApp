package com.example.refapplication.repo;

import com.example.refapplication.model.RandomPoem;
import com.example.refapplication.network.RetrofitInstance;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Repo {

    public Single<List<RandomPoem>> getRepoClientCallThing() {
        return  RetrofitInstance.service.getRandomPoem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
