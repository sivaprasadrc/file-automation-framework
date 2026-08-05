package com.siva.fileautomation.scanner.model;

import java.nio.file.Path;

public record ScanRequest(
        Path directory
) {
}
