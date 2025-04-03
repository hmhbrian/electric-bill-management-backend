package com.example.demo.DTO;

public class AvatarDTO {
    private String avatarUrl;
    public AvatarDTO(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
