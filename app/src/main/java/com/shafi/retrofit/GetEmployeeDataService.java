package com.shafi.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GetEmployeeDataService {
    @GET("users")
    Call<List<Model>> getEmployeeData();
}
