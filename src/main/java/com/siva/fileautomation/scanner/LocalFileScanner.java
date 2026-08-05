package com.siva.fileautomation.scanner;

import com.siva.fileautomation.scanner.model.ScanRequest;
import com.siva.fileautomation.scanner.model.ScanResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LocalFileScanner implements FileScanner {

    @Override
    public ScanResult scan(ScanRequest request) {

        if (request.directory() == null) {
            throw new IllegalArgumentException("Scan directory cannot be null.");
        }

        try {

            List<Path> files = Files.list(request.directory())
                    .filter(Files::isRegularFile)
                    .toList();

            return new ScanResult(files);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}