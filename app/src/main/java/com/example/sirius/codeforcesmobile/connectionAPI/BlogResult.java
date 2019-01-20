package com.example.sirius.codeforcesmobile.connectionAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BlogResult {
    @SerializedName("originalLocale")
    @Expose
    private String originalLocale;
    @SerializedName("allowViewHistory")
    @Expose
    private Boolean allowViewHistory;
    @SerializedName("creationTimeSeconds")
    @Expose
    private Integer creationTimeSeconds;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("authorHandle")
    @Expose
    private String authorHandle;
    @SerializedName("modificationTimeSeconds")
    @Expose
    private Integer modificationTimeSeconds;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;

    public String getOriginalLocale() {
        return originalLocale;
    }

    public void setOriginalLocale(String originalLocale) {
        this.originalLocale = originalLocale;
    }

    public Boolean getAllowViewHistory() {
        return allowViewHistory;
    }

    public void setAllowViewHistory(Boolean allowViewHistory) {
        this.allowViewHistory = allowViewHistory;
    }

    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    public void setCreationTimeSeconds(Integer creationTimeSeconds) {
        this.creationTimeSeconds = creationTimeSeconds;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAuthorHandle() {
        return authorHandle;
    }

    public void setAuthorHandle(String authorHandle) {
        this.authorHandle = authorHandle;
    }

    public Integer getModificationTimeSeconds() {
        return modificationTimeSeconds;
    }

    public void setModificationTimeSeconds(Integer modificationTimeSeconds) {
        this.modificationTimeSeconds = modificationTimeSeconds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
