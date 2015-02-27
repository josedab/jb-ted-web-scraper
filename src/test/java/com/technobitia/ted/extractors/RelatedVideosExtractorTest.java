package com.technobitia.ted.extractors;

import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.technobitia.ted.exceptions.TedScraperException;
import com.technobitia.ted.extractors.RelatedVideosExtractor;
import com.technobitia.ted.request.TedScraperRequest;

@RunWith(MockitoJUnitRunner.class)
public class RelatedVideosExtractorTest {

    @Mock
    private Document documentMock;
    
    @Mock
    private TedScraperRequest tedRequestMock;
    
    @InjectMocks
    private RelatedVideosExtractor sidebarExtractor;

    @Test(expected = NullPointerException.class)
    public void whenExtractingInformation_givenNullRequest_thenThrowNPE() throws TedScraperException {
        sidebarExtractor.extract(null, documentMock);
    }

    @Test(expected = NullPointerException.class)
    public void whenExtractingInformation_givenNullDocument_thenThrowNPE() throws TedScraperException {
        sidebarExtractor.extract(tedRequestMock, null);
    }
}
