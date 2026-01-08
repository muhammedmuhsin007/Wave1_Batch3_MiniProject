package com.ust.project;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class CertificateGenerator {

    public static void generateCertificate(Employee employee, Training training) {

        if (training.getStatus() != Training.Status.COMPLETED) {
            System.out.println("Training not completed. Certificate not generated.");
            return;
        }

        String fileName = "Certificate_" + employee.getEmpName() + "_" +
                training.getTrainingName().replace(" ", "_") + ".pdf";

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream content = new PDPageContentStream(document, page);

            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 18);
            content.newLineAtOffset(100, 700);
            content.showText("TRAINING CERTIFICATE");
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 12);
            content.newLineAtOffset(100, 650);
            content.showText("This certifies that " + employee.getEmpName());
            content.newLineAtOffset(0, -20);
            content.showText("has successfully completed the training:");
            content.newLineAtOffset(0, -20);
            content.showText(training.getTrainingName());
            content.newLineAtOffset(0, -20);
            content.showText("Trainer: " + training.getTrainerName());
            content.endText();

            content.close();

            document.save(new File(fileName));

            System.out.println("PDF Certificate generated: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
