package com.technobitia.ted.client;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.technobitia.ted.exceptions.TedScraperException;
import com.technobitia.ted.extractors.AuthorExtractor;
import com.technobitia.ted.extractors.Extractor;
import com.technobitia.ted.extractors.RelatedVideosExtractor;
import com.technobitia.ted.model.Author;
import com.technobitia.ted.model.RelatedVideo;
import com.technobitia.ted.model.TalkData;
import com.technobitia.ted.request.TedScraperRequest;

public class TedScraperClient {
    private Extractor<List<RelatedVideo>> relatedVideosExtractor;
    private Extractor<List<Author>> authorExtractor;

    public TedScraperClient() {
        relatedVideosExtractor = new RelatedVideosExtractor();
        authorExtractor = new AuthorExtractor();
    }

    public List<RelatedVideo> extractRelatedVideos(TedScraperRequest request) throws TedScraperException {
        checkNotNull(request);
        List<RelatedVideo> result = null;

        String url = request.getUrl();
        try {
            Document doc = Jsoup.connect(url).get();
            result = relatedVideosExtractor.extract(request, doc);
        } catch (IOException e) {
            throw new TedScraperException("I/O exception when requesting information to url:" + url);
        }
        
        return result;
    }
    
    public List<Author> extractAuthorInformation(TedScraperRequest request) throws TedScraperException {
        checkNotNull(request);
        List<Author> result = null;

        String url = request.getUrl();
        try {
            Document doc = Jsoup.connect(url).get();
            result = authorExtractor.extract(request, doc);
        } catch (IOException e) {
            throw new TedScraperException("I/O exception when requesting information to url:" + url);
        }
        
        return result;
    }
    
    public TalkData extractTalkData(TedScraperRequest request) throws TedScraperException {
        checkNotNull(request);

        TalkData talkData = null;
        String url = request.getUrl();
        try {
            Document doc = Jsoup.connect(url).get();
            List<Author> authors = authorExtractor.extract(request, doc);
            List<RelatedVideo> relatedVideos = relatedVideosExtractor.extract(request, doc);
            talkData = new TalkData();
            talkData.setAuthors(authors);
            talkData.setRelatedVideos(relatedVideos);
        } catch (IOException e) {
            throw new TedScraperException("I/O exception when requesting information to url:" + url);
        }
        
        return talkData;
    }
}
