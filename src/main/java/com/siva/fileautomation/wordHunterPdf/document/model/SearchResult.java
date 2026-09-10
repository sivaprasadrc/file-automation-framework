package com.siva.fileautomation.wordHunterPdf.document.model;

public record SearchResult(String fileName,int pageNumber,String searchWord,int occurrence) {
}