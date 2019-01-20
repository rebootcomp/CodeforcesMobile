package com.example.sirius.codeforcesmobile.connectionAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Blog {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private BlogResult result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BlogResult getResult() {
        return result;
    }

    public void setResult(BlogResult result) {
        this.result = result;
    }

}
