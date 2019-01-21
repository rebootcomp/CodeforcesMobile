package com.example.sirius.codeforcesmobile.connectionAPI;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProblemsResult {

    @SerializedName("problems")
    @Expose
    private List<ProblemResult> problems = null;

    public List<ProblemResult> getProblems() {
        return problems;
    }

    public void setProblems(List<ProblemResult> problems) {
        this.problems = problems;
    }

}