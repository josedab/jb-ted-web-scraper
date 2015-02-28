package com.technobitia.ted.examples;

import java.util.List;

import com.technobitia.ted.client.TedScraperClient;
import com.technobitia.ted.exceptions.TedScraperException;
import com.technobitia.ted.model.Author;
import com.technobitia.ted.request.TedScraperRequest;

public class AuthorExtractorApp {

    public static void main(String[] args) throws TedScraperException {
        String url = "http://www.ted.com/talks/rob_knight_how_our_microbes_make_us_who_we_are";
        TedScraperRequest request = new TedScraperRequest.Builder(url)
                                                        .build();
        TedScraperClient client = new TedScraperClient();
        List<Author> authors = client.extractAuthorInformation(request);
        System.out.println(authors);

    }

}
