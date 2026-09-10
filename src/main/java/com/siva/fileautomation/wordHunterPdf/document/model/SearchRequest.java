package com.siva.fileautomation.wordHunterPdf.document.model;

import com.siva.fileautomation.wordHunterPdf.document.search.SearchMode;

import java.nio.file.Path;
//A class is a general-purpose blueprint. A record is a special, simpler type mainly designed to hold data.

public record SearchRequest(Path file,String searchWord, SearchMode searchMode) {
}
