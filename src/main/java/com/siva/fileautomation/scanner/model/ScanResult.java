package com.siva.fileautomation.scanner.model;

import java.nio.file.Path;
import java.time.Duration;
import java.util.List;

public record  ScanResult(
        List<Path> files
//        long totalFiles,
//        Duration executionTime
) {
}
