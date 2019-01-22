package com.example.sirius.codeforcesmobile.connectionAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ContestsInterface {
    @GET("/api/contest.list")
    Call<Contests> getContests(@Query("gym") String gym);
}
