package fileautomation.wordHunterPdf.document.ocr;

import com.siva.fileautomation.wordHunterPdf.document.ocr.PdfPageRenderer;
import com.siva.fileautomation.wordHunterPdf.document.ocr.TesseractOcrEngine;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesseractOcrEngineTest {
    @Test
    void shouldExtractTextFromScannedPdfPage() throws IOException {
    Path pdfFile = Path.of("src/test/resources/wordHunterPdfFiles/Test.pdf");
    try(PDDocument document = Loader.loadPDF(pdfFile.toFile())) {
        PdfPageRenderer renderer = new PdfPageRenderer(document);
        BufferedImage image = renderer.render(1);
        TesseractOcrEngine ocrEngine = new TesseractOcrEngine();
        String text = ocrEngine.recognize(image);
        System.out.println("OCR RESULT:");
        System.out.println(text);
        assertTrue(
                text.contains("Pin code"),
                "OCR should recognize the word Pin code"
        );
    }
    }
}
