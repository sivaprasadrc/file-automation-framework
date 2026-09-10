package com.siva.fileautomation;

import com.siva.fileautomation.converter.ImageConverter;
import com.siva.fileautomation.converter.ImageMagickConverter;
import com.siva.fileautomation.engine.RenameEngine;
import com.siva.fileautomation.engine.ConversionEngine;
import com.siva.fileautomation.wordHunterPdf.document.model.SearchRequest;
import com.siva.fileautomation.wordHunterPdf.document.model.SearchResult;
import com.siva.fileautomation.wordHunterPdf.document.search.DocumentSearchEngine;
import com.siva.fileautomation.wordHunterPdf.document.search.SearchMode;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        System.out.println("==================================");
        System.out.println(" File Automation Framework v1.0");
        System.out.println("==================================");

//        RenameEngine engine = new RenameEngine();
//        engine.rename(Path.of("C:\\Users\\Admin\\Videos\\WinX YouTube Downloader\\QFR - ILAYARAJA SONGS"));
//        ImageConverter converter =
//                new ImageMagickConverter();
//
//
//        ConversionEngine engine =
//                new ConversionEngine(converter);
//
//
//        engine.convertFolder(
//                Path.of("E:\\Nandhalala Asset")
//        );

        Path pdfFile = Path.of("src/main/resources/wordHunterPdfFiles/Test pdf.pdf");
        SearchRequest request = new SearchRequest(pdfFile,"Ram", SearchMode.CONTAINS);
        DocumentSearchEngine engine = new DocumentSearchEngine();
        List<SearchResult> results = engine.search(request);
        for (SearchResult result : results) {
            System.out.println(result);
        }
        System.out.println("Total occurrences: " + results.size());


    }
}