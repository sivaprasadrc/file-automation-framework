package com.siva.fileautomation.converter;

import java.nio.file.Path;

public class ConversionResult {

    private boolean success;
    private Path outputFile;
    private String message;


    public ConversionResult(boolean success,
                            Path outputFile,
                            String message) {

        this.success = success;
        this.outputFile = outputFile;
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }


    public Path getOutputFile() {
        return outputFile;
    }


    public String getMessage() {
        return message;
    }
}