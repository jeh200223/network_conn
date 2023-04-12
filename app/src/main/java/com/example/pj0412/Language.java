package com.example.pj0412;

public class Language {
    private String name;
    private String imageUrl;
    private String desc;

    public Language(String name, String imageUrl, String desc) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDesc() {
        return desc;
    }
}
