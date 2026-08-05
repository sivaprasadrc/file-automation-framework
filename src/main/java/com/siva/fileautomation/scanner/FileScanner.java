package com.siva.fileautomation.scanner;

import com.siva.fileautomation.scanner.model.ScanRequest;
import com.siva.fileautomation.scanner.model.ScanResult;
//Open/Closed Principle (OCP)
//Open for extension
//Closed for modification



public interface FileScanner {
    ScanResult scan(ScanRequest request);
}
