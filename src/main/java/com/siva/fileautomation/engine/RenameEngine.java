package com.siva.fileautomation.engine;

import com.siva.fileautomation.scanner.FileScanner;
import com.siva.fileautomation.scanner.factory.ScannerFactory;
import com.siva.fileautomation.scanner.model.ScanRequest;
import com.siva.fileautomation.scanner.model.ScanResult;

import java.nio.file.Path;
import java.util.Arrays;

public class RenameEngine {

    public void rename(Path directory) {

        // Get scanner
        FileScanner scanner = ScannerFactory.getScanner();

        // Create request
        ScanRequest request = new ScanRequest(directory);

        // Scan
        ScanResult result = scanner.scan(request);

        // Print all file names
        result.files().forEach(path -> {

            String oldName = path.getFileName().toString();

            String newName = splitName(oldName);

            Path newPath = path.resolveSibling(newName);

            try {
                java.nio.file.Files.move(path, newPath);
                System.out.println(oldName + " --> " + newName);
            } catch (java.io.IOException e) {
                throw new RuntimeException("Failed to rename " + oldName, e);
            }

        });
    }

    String splitName(String fileName){

        String str = fileName;
        if(fileName.contains("mp4")){
            String[] arr = fileName.substring(0,fileName.length()-4).split("Episode");
            if(arr.length==2){
                str = "Episode"+arr[1]+" "+arr[0]+"Ilaiyaraaja.mp4";
            }

        }

        return str;
    }
}