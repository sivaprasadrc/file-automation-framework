package com.siva.fileautomation.wordHunterPdf.document.search;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;

public interface  PageTextExtractor {
    String extractText(PDDocument document, int pageNumber) throws IOException;
}
