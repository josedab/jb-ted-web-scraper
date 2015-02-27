package com.technobitia.ted.extractors;

import org.jsoup.nodes.Document;

import com.technobitia.ted.request.TedScraperRequest;

public interface Extractor<T> {
    public T extract(TedScraperRequest request, Document doc);
}
