package com.siva.fileautomation.wordHunterPdf.document.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;

public class TesseractOcrEngine implements OcrEngine{
    private final Tesseract tesseract;
    public TesseractOcrEngine(){
        this.tesseract = new Tesseract();
        tesseract.setDatapath(
                "C:\\Program Files\\Tesseract-OCR\\tessdata"
        );
        tesseract.setLanguage("eng");

    }
    @Override
    public String recognize(BufferedImage image) {
        try{
            return tesseract.doOCR(image);
        } catch (TesseractException e) {
            throw new RuntimeException("OCR failed", e);
        }
    }
}
