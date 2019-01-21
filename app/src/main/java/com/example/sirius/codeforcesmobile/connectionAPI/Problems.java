package com.example.sirius.codeforcesmobile.connectionAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Problems {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private  ProblemsResult result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProblemsResult getResult() {
        return result;
    }

    public void setResult(ProblemsResult result) {
        this.result = result;
    }

}