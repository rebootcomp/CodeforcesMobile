package com.example.sirius.codeforcesmobile.connectionAPI;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private List<UserResult> result = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<UserResult> getResult() {
        return result;
    }

    public void setResult(List<UserResult> result) {
        this.result = result;
    }

}

//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;
//
//import java.util.ArrayList;
//import java.util.List;
//public class User {
//    @SerializedName("handle")
////    @Expose
//    public String handle;
//    @SerializedName("email")
////    @Expose
//    public String email;
//    @SerializedName("vkid")
////    @Expose
//    public String vkid;
//    @SerializedName("openId")
////    @Expose
//    public String openId;
//    @SerializedName("firstName")
////    @Expose
//    public String firstName;
//    @SerializedName("lastName")
////    @Expose
//    public String lastName;
//    @SerializedName("country")
////    @Expose
//    public String country;
//    @SerializedName("city")
////    @Expose
//    public String city;
//    @SerializedName("organization")
////    @Expose
//    public String organization;
//    @SerializedName("contribution")
////    @Expose
//    public String contribution;
//    @SerializedName("rank")
////    @Expose
//    public String rank;
//    @SerializedName("rating")
////    @Expose
//    public int rating;
//    @SerializedName("maxRank")
////    @Expose
//    public String maxRank;
//    @SerializedName("rank")
////    @Expose
//    public String maxRating;
//    @SerializedName("lastOnlineTimeSeconds")
////    @Expose
//    public int lastOnlineTimeSeconds;
//    @SerializedName("registrationTimeSeconds")
////    @Expose
//    public int registrationTimeSeconds;
//    @SerializedName("registrationTimeSeconds")
////    @Expose
//    public int friendOfCount;
//    @SerializedName("avatar")
////    @Expose
//    public String avatar;
//    @SerializedName("titlePhoto")
////    @Expose
//    public String titlePhoto;
//
//    public User() {}
//
//    public String getHandle() {
//        return handle;
//    }
//
//    public int getFriendOfCount() {
//        return friendOfCount;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public int getLastOnlineTimeSeconds() {
//        return lastOnlineTimeSeconds;
//    }
//
//    public int getRegistrationTimeSeconds() {
//        return registrationTimeSeconds;
//    }
//
//    public String getAvatar() {
//        return avatar;
//    }
//
//    public String getContribution() {
//        return contribution;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getMaxRank() {
//        return maxRank;
//    }
//
//    public String getMaxRating() {
//        return maxRating;
//    }
//
//    public String getOpenId() {
//        return openId;
//    }
//
//    public String getOrganization() {
//        return organization;
//    }
//
//    public String getRank() {
//        return rank;
//    }
//
//    public String getTitlePhoto() {
//        return titlePhoto;
//    }
//
//    public String getVkid() {
//        return vkid;
//    }
//}


