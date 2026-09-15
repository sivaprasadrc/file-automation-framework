package com.siva.fileautomation.wordHunterPdf.document.search;

public class PageClassifier {
    public PageType classify(String pageText){
        if(pageText==null||pageText.isBlank()){
            return PageType.SCANNED;
        }
        return PageType.TEXT;
    }
}
