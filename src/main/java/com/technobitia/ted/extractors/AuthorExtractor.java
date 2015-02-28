package com.technobitia.ted.extractors;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.common.collect.Lists;
import com.technobitia.ted.model.Author;
import com.technobitia.ted.request.TedScraperRequest;

public class AuthorExtractor implements Extractor<List<Author>> {

    private static final String AUTHOR_SELECTOR = ".talk-speaker";
    private static final String NAME_SELECTOR = ".talk-speaker__link";
    private static final String DESCRIPTION_SELECTOR = ".talk-speaker__description";
    private static final String BIO_SELECTOR = ".talk-speaker__bio";
    private static final String IMAGE_SELECTOR = ".thumb__image";
    private static final String LINK_SELECTOR = ".talk-speaker__link";

    public List<Author> extract(TedScraperRequest request, Document doc) {
        checkNotNull(request);
        checkNotNull(doc);

        List<Author> authors = Lists.newArrayList();
        Elements results = doc.select(AUTHOR_SELECTOR);
        
        for(Element authorElement: results){
            Author author = convertToAuthor(authorElement);
            authors.add(author);
        }
        return authors;
    }

    private Author convertToAuthor(Element element) {
        Author author = new Author();
        author.setName(element.select(NAME_SELECTOR).text());
        author.setDescription(element.select(DESCRIPTION_SELECTOR).text());
        author.setImageUrl(element.select(IMAGE_SELECTOR).attr("src"));
        author.setBio(element.select(BIO_SELECTOR).text());
        author.setLink(element.select(LINK_SELECTOR).first().absUrl("href"));
        return author;
    }

}
