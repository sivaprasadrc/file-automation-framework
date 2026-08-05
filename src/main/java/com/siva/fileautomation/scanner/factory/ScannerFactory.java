package com.siva.fileautomation.scanner.factory;

import com.siva.fileautomation.scanner.FileScanner;
import com.siva.fileautomation.scanner.LocalFileScanner;

//Factory is not part of the domain model.
//Nobody should inherit it.
//It has one responsibility.
public final class ScannerFactory {
    private ScannerFactory() {
    }

    public static FileScanner getScanner() {
        return new LocalFileScanner();
    }
}
