package com.siva.fileautomation.wordHunterPdf.document.ocr;

import java.awt.image.BufferedImage;

public interface OcrEngine {
    String recognize(BufferedImage image);
}
