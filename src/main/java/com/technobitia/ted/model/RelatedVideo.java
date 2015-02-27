package com.technobitia.ted.model;

import com.google.common.base.MoreObjects;

public class RelatedVideo {
    private String author;
    private String imagePreview;
    private String title;
    private String link;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImagePreview() {
        return imagePreview;
    }

    public void setImagePreview(String imagePreview) {
        this.imagePreview = imagePreview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                           .add("title", title)
                           .add("author", author)
                           .add("image", imagePreview)
                           .add("url", link)
                           .toString();
    }

}
