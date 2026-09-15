package com.siva.fileautomation.wordHunterPdf.document.ocr;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

public class TesseractOcrEngineTest {
    @Test
    void shouldExtractTextFromScannedPdfPage() throws IOException {
    Path pdfFile = Path.of("src/main/resources/wordHunterPdfFiles/Test.pdf");
    try(PDDocument document = Loader.loadPDF(pdfFile.toFile())) {
        PdfPageRenderer renderer = new PdfPageRenderer(document);
        BufferedImage image = renderer.render(1);
        TesseractOcrEngine ocrEngine = new TesseractOcrEngine();
        String text = ocrEngine.recognize(image);
        System.out.println("OCR RESULT:");
        System.out.println(text);
    }
    }
}
