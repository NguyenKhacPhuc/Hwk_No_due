package com.example.hwk_no_due;

public class Feed {
    private int avatar;
    private String username;
    private String time;
    private int image;
    private String status;

    public Feed(int avatar, String username, String time, int image, String status) {
        this.avatar = avatar;
        this.username = username;
        this.time = time;
        this.image = image;
        this.status = status;
    }
    public Feed(){

    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
