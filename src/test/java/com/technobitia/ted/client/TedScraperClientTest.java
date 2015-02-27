package com.technobitia.ted.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.technobitia.ted.client.TedScraperClient;
import com.technobitia.ted.exceptions.TedScraperException;

@RunWith(MockitoJUnitRunner.class)
public class TedScraperClientTest {

    @InjectMocks
    private TedScraperClient tedClient;

    @Test(expected = NullPointerException.class)
    public void whenExtractingInformation_givenNullRequest_thenThrowNPE() throws TedScraperException {
        tedClient.extractRelatedVideos(null);
    }
}
