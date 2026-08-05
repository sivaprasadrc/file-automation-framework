package com.siva.fileautomation;

import com.siva.fileautomation.converter.ImageConverter;
import com.siva.fileautomation.converter.ImageMagickConverter;
import com.siva.fileautomation.engine.RenameEngine;
import com.siva.fileautomation.engine.ConversionEngine;

import java.nio.file.Path;

public class Application {

    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println(" File Automation Framework v1.0");
        System.out.println("==================================");

        RenameEngine engine = new RenameEngine();
        engine.rename(Path.of("C:\\Users\\Admin\\Videos\\WinX YouTube Downloader\\QFR - ILAYARAJA SONGS"));
//        ImageConverter converter =
//                new ImageMagickConverter();
//
//
//        ConversionEngine engine =
//                new ConversionEngine(converter);
//
//
//        engine.convertFolder(
//                Path.of("E:\\Nandhalala Asset")
//        );

    }
}