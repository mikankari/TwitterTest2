package com.example.twittertest2;

public class Status {
    private String text;            // �c�C�[�g���e
    private String screenName;      // ���[�U�[��
    private String profileImageUrl; // �A�C�R���摜URL
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
