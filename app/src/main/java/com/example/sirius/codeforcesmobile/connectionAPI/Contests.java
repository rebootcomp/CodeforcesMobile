package com.example.sirius.codeforcesmobile.connectionAPI;

import com.google.gson.annotations.Expose;
import java.util.List;

import com.google.gson.annotations.SerializedName;
public class Contests {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private List<ContestResult> result = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContestResult> getResult() {
        return result;
    }

    public void setResult(List<ContestResult> result) {
        this.result = result;
    }

}
