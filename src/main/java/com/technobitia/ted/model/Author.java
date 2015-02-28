package com.technobitia.ted.model;

import com.google.common.base.MoreObjects;

public class Author {
    private String name;
    private String imageUrl;
    private String description;
    private String bio;
    private String link;

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                           .add("name", name)
                           .add("image", imageUrl)
                           .add("description", description)
                           .add("link", link)
                           .toString();
    }
}
