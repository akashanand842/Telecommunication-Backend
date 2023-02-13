package com.teleconsultation.Service;

import com.teleconsultation.Entity.Prescription;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
@Service
public class FileServiceImpl implements FileService{
    public byte[] generatePdfFile(Prescription prescription) {
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream();
             PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            PDPageContentStream content = new PDPageContentStream(document, page);

            PDFont font = PDType1Font.TIMES_ROMAN;
            float fontSize = 12;
            float leading = 1.5f * fontSize;

            content.beginText();
            content.setFont(font, fontSize);
            content.newLineAtOffset(72, 720);
            content.showText("Doctor Name: " + prescription.getMedicineName());
            content.newLineAtOffset(0, -leading);
            content.showText("Patient Name: " + prescription.getDosage());
            content.newLineAtOffset(0, -leading);
            content.showText("Patient Name: " + prescription.getDuration());

            // Add other prescription details to the PDF document

            content.endText();
            content.close();
            document.save(stream);
            return stream.toByteArray();
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to generate PDF file: " + e.getMessage());
        }
    }
}
