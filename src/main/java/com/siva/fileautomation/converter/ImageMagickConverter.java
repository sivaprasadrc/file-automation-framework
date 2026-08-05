package com.siva.fileautomation.converter;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class ImageMagickConverter implements ImageConverter {

    @Override
    public void convert(Path inputFile) {
        String fileName = inputFile.getFileName().toString();

        int dotIndex = fileName.lastIndexOf('.');
        if(dotIndex == -1){
            throw new RuntimeException("Invalid image file");
        }

        String outputFileName = fileName.substring(0, dotIndex) + ".jpg";
        Path outputDirectory =
                inputFile.resolveSibling("Output");
        Path reportDirectory =
                inputFile.resolveSibling("Reports");


        try {
            Files.createDirectories(outputDirectory);
            Files.createDirectories(reportDirectory);
        }
        catch(IOException e){
            throw new RuntimeException("Unable to create output folder", e);
        }

        Path outputFile = inputFile.resolveSibling("Output").resolve(outputFileName);
        Path reportFile = reportDirectory.resolve("conversion-report.txt");
        System.out.println("Input File : " + inputFile);

        System.out.println("Output File : " + outputFile);

        try {

            ProcessBuilder processBuilder =
                    new ProcessBuilder(
                            "magick",
                            inputFile.toString(),
                            outputFile.toString()
                    );


            Process process =
                    processBuilder.start();


            int result =
                    process.waitFor();


            if(result == 0){

                System.out.println(
                        "Conversion Successful"
                );
                String report =
                        "SUCCESS\n" +
                                "Input : " + inputFile + "\n" +
                                "Output: " + outputFile + "\n\n";


                Files.writeString(
                        reportFile,
                        report,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND
                );

            }
            else{

                System.out.println(
                        "Conversion Failed"
                );

            }


        }
        catch(IOException | InterruptedException e){

            throw new RuntimeException(
                    "Image conversion error",
                    e
            );

        }
    }
}