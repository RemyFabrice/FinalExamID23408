package com.FinalProject.FExam.Model;


import org.springframework.stereotype.Component;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PdfGenerator {

    public ByteArrayOutputStream generatePdfReport(List<Admision> evaluations, String admittedFilter) throws DocumentException {
        List<Admision> filteredEvaluations = evaluations.stream()
                .filter(evaluation -> evaluation.getAdmitted().equalsIgnoreCase(admittedFilter))
                .collect(Collectors.toList());

        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);

        document.open();

        Font font = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        String titleText = admittedFilter.equalsIgnoreCase("YES") ? "Admitted Evaluations" : "Non-Admitted Evaluations";
        Paragraph title = new Paragraph(titleText, font);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);

        table.addCell("FirstNAme");
        table.addCell("Other Name");
        table.addCell("Reason");
        table.addCell("Admitted");

        for (Admision evaluation : filteredEvaluations) {
            table.addCell(evaluation.getEvaluation().getSupportingDocuments().getApplic().getFirstName());
            table.addCell(evaluation.getEvaluation().getSupportingDocuments().getApplic().getFamilyName());
            table.addCell(evaluation.getEvaluation().getOveralremarks());
            table.addCell(evaluation.getAdmitted());
        }

        document.add(table);
        document.close();

        return outputStream;
    }
}
