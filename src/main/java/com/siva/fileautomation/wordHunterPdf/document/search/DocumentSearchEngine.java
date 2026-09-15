package com.siva.fileautomation.wordHunterPdf.document.search;

import com.siva.fileautomation.wordHunterPdf.document.model.SearchRequest;
import com.siva.fileautomation.wordHunterPdf.document.model.SearchResult;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentSearchEngine {
    private final PageTextExtractor textExtractor;
    private final PageClassifier pageClassifier;

    public DocumentSearchEngine(PageTextExtractor textExtractor, PageClassifier pageClassifier) {
        this.textExtractor = textExtractor;
        this.pageClassifier = pageClassifier;
    }


    public List<SearchResult> search(SearchRequest request) throws IOException {
        List<SearchResult> results = new ArrayList<>();
        try (PDDocument document = Loader.loadPDF(request.file().toFile())) {

            for (int pageNumber = 1; pageNumber <= document.getNumberOfPages(); pageNumber++) {

                String pageText = textExtractor.extractText(document, pageNumber);
                PageType pageType = pageClassifier.classify(pageText);
                System.out.println(
                        "Page " + pageNumber + " → " + pageType
                );
                int occurrence = countOccurrences(pageText, request.searchWord(), request.searchMode());
                for (int i = 1; i <= occurrence; i++) {
                    results.add(new SearchResult(request.file().getFileName().toString(), pageNumber, request.searchWord(), i));
                }
            }
        }

        return results;
    }

    private int countOccurrences(String text, String searchWord, SearchMode searchMode) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(searchWord, index)) != -1) {
            switch (searchMode) {
                case CONTAINS:
                    count++;
                    break;
                case WHOLE_WORD:
                    break;
                case EXACT:
                    break;

            }


            index += searchWord.length();
        }

        return count;
    }
}
