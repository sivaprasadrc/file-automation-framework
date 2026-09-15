package com.siva.fileautomation.wordHunterPdf.document.ocr;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class PdfPageRenderer {
    private final PDFRenderer renderer;
    public PdfPageRenderer(PDDocument document){
        this.renderer = new PDFRenderer(document);
    }
    public BufferedImage render(int pageNumber) throws IOException {
        return renderer.renderImageWithDPI(pageNumber-1,300);
    }
}
