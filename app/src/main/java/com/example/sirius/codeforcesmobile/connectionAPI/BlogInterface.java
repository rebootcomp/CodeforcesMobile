package com.example.sirius.codeforcesmobile.connectionAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BlogInterface {
    @GET("/api/blogEntry.view")
     Call<Blog> getBlog(@Query("blogEntryId") String blogEntryId);
}
