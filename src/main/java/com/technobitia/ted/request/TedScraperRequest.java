package com.technobitia.ted.request;

public class TedScraperRequest {

    private final String url;

    private TedScraperRequest(Builder requestBuilder) {
        this.url = requestBuilder.url;
    }

    public String getUrl() {
        return url;
    }

    public static class Builder {
        private final String url;

        public Builder(String url) {
            this.url = url;
        }

        public TedScraperRequest build() {
            return new TedScraperRequest(this);
        }
    }
}
