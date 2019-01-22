package com.example.sirius.codeforcesmobile.connectionAPI;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ContestResult {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("phase")
        @Expose
        private String phase;
        @SerializedName("frozen")
        @Expose
        private Boolean frozen;
        @SerializedName("durationSeconds")
        @Expose
        private Integer durationSeconds;
        @SerializedName("startTimeSeconds")
        @Expose
        private Integer startTimeSeconds;
        @SerializedName("relativeTimeSeconds")
        @Expose
        private Integer relativeTimeSeconds;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPhase() {
            return phase;
        }

        public void setPhase(String phase) {
            this.phase = phase;
        }

        public Boolean getFrozen() {
            return frozen;
        }

        public void setFrozen(Boolean frozen) {
            this.frozen = frozen;
        }

        public Integer getDurationSeconds() {
            return durationSeconds;
        }

        public void setDurationSeconds(Integer durationSeconds) {
            this.durationSeconds = durationSeconds;
        }

        public Integer getStartTimeSeconds() {
            return startTimeSeconds;
        }

        public void setStartTimeSeconds(Integer startTimeSeconds) {
            this.startTimeSeconds = startTimeSeconds;
        }

        public Integer getRelativeTimeSeconds() {
            return relativeTimeSeconds;
        }

        public void setRelativeTimeSeconds(Integer relativeTimeSeconds) {
            this.relativeTimeSeconds = relativeTimeSeconds;
        }

    }

