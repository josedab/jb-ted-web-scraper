package com.technobitia.ted.model;

import java.util.List;

public class TalkData {
    private String url;
    private List<Author> authors;
    private List<RelatedVideo> relatedVideos;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<RelatedVideo> getRelatedVideos() {
        return relatedVideos;
    }

    public void setRelatedVideos(List<RelatedVideo> relatedVideos) {
        this.relatedVideos = relatedVideos;
    }

}
