package com.example.refapplication.network;

import com.example.refapplication.model.RandomPoem;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface PoemClient {
    @GET("random")
    Single<List<RandomPoem>> getRandomPoem();
}
