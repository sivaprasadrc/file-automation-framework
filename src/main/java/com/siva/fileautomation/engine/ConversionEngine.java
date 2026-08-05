package com.siva.fileautomation.engine;

import com.siva.fileautomation.converter.ImageConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConversionEngine {

    private final ImageConverter converter;


    public ConversionEngine(ImageConverter converter) {
        this.converter = converter;
    }


    public void convertFolder(Path folder) {

        try {

            Files.list(folder)
                    .filter(path -> path.toString().endsWith(".NEF"))
                    .forEach(converter::convert);


        }
        catch(IOException e) {

            throw new RuntimeException(
                    "Unable to scan folder",
                    e
            );

        }

    }
}