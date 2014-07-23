package com.example.twittertest2;

public class Status {
    private String text;            // ツイート内容
    private String screenName;      // ユーザー名
    private String profileImageUrl; // アイコン画像URL
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getScreenName() {
        return screenName;
    }
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
    public String getProfileImageUrl() {
        return profileImageUrl;
    }
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
