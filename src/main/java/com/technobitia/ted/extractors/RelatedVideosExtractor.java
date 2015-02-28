package com.technobitia.ted.extractors;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Lists;
import com.technobitia.ted.model.RelatedVideo;
import com.technobitia.ted.request.TedScraperRequest;

public class RelatedVideosExtractor implements Extractor<List<RelatedVideo>> {

    private static final String RELATED_VIDEOS_SELECTOR = ".talk-related .talk-related__item";
    private static final String IMAGE_SELECTOR = ".thumb__image";
    private static final String TITLE_SELECTOR = ".talk-next__title";
    private static final String LINK_SELECTOR = ".talk-next__link";
    private static final String AUTHOR_SELECTOR = ".talk-next__speaker";

    public List<RelatedVideo> extract(TedScraperRequest request, Document doc) {
        checkNotNull(request);
        checkNotNull(doc);

        List<RelatedVideo> relatedVideos = Lists.newArrayList();
        Elements results = doc.select(RELATED_VIDEOS_SELECTOR);

        Iterator<Element> it = results.iterator();
        while (it.hasNext()) {
            Element resultElement = it.next();
            RelatedVideo relatedVideo = convertToRelatedVideo(resultElement);
            if (relatedVideo != null) {
                relatedVideos.add(relatedVideo);
            }
        }
        return relatedVideos;
    }

    private RelatedVideo convertToRelatedVideo(Element element) {
        RelatedVideo relatedVideo = new RelatedVideo();
        String imageUrl = element.select(IMAGE_SELECTOR).attr("src");
        String title = element.select(TITLE_SELECTOR).text();
        String link = element.select(LINK_SELECTOR).first().absUrl("href");
        String author = element.select(AUTHOR_SELECTOR).text();
        relatedVideo.setImagePreview(imageUrl);
        relatedVideo.setTitle(title);
        relatedVideo.setAuthor(author);
        relatedVideo.setLink(link);
        return relatedVideo;
    }

}
