package org.example.aplikaceproskolu.pdfExport;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.example.aplikaceproskolu.objekty.Problem;
import org.example.aplikaceproskolu.objekty.Users;
import org.example.aplikaceproskolu.repo.ProblemRepo;
import org.example.aplikaceproskolu.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.List;

@Service
public class PDFGeneratorService {
    @Autowired
    ProblemRepo problemRepo;
    @Autowired
    UserRepo userRepo;

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        String month = getMonth(calendar);
        calendar.setTime(date);

        List<Problem> problemList = problemRepo.getProblemByMonthAndYear(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, Sort.by(Sort.Direction.DESC, "time"));

        List<Object[]> usersList = userRepo.getUsersByMostProblems(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, Sort.by(Sort.Direction.DESC, "problem_count"));
        List<Object[]> adminList = userRepo.getUsersByProblemSolved(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, Sort.by(Sort.Direction.DESC, "problem_count"));
        document.open();
        Font fontHeader = FontFactory.getFont("Arial", 22);

        Paragraph problemHeader = new Paragraph("Problémy za měsíc " + month + " " + calendar.get(Calendar.YEAR), fontHeader);
        problemHeader.setAlignment(Element.ALIGN_CENTER);
        problemHeader.setSpacingAfter(25);

        PdfPTable problemTable = createProblemTable(problemList);
        problemTable.setSpacingAfter(35);

        Paragraph userHeader = new Paragraph("Zadané problémy učiteli", fontHeader);
        userHeader.setAlignment(Element.ALIGN_CENTER);
        userHeader.setSpacingAfter(25);

        PdfPTable usersTable = createUserTable(usersList);
        usersTable.setSpacingAfter(35);

        Paragraph adminHeader = new Paragraph("Vyřešené problémy učiteli", fontHeader);
        adminHeader.setAlignment(Element.ALIGN_CENTER);
        adminHeader.setSpacingAfter(25);

        PdfPTable adminTable = createUserTable(adminList);

        document.add(problemHeader);
        document.add(problemTable);
        document.add(userHeader);
        document.add(usersTable);
        document.add(adminHeader);
        document.add(adminTable);
        document.close();
    }

    private PdfPTable createProblemTable(List<Problem> problemList) {
        float[] columnWidths = new float[]{2f, 1f};
        PdfPTable table = new PdfPTable(2);
        table.setWidths(columnWidths);

        Font cellHeader = FontFactory.getFont("Arial", 18);

        PdfPCell cell1 = new PdfPCell(new Phrase("Problém", cellHeader));
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell1.setPaddingTop(10);
        cell1.setPaddingBottom(10);

        PdfPCell cell2 = new PdfPCell(new Phrase("Čas", cellHeader));
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell2.setPaddingTop(10);
        cell2.setPaddingBottom(10);

        table.addCell(cell1);
        table.addCell(cell2);

        for (Problem problem : problemList) {
            PdfPCell jmeno = new PdfPCell(new Phrase(problem.getName()));
            jmeno.setVerticalAlignment(Element.ALIGN_MIDDLE);
            jmeno.setPaddingBottom(5);
            jmeno.setPaddingTop(5);

            PdfPCell cas = new PdfPCell(new Phrase(problem.getTime() == 0 ? "Nevyřešeno" : problem.getTime().toString()));
            cas.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cas.setHorizontalAlignment(Element.ALIGN_CENTER);
            cas.setPaddingBottom(5);
            cas.setPaddingTop(5);

            table.addCell(jmeno);
            table.addCell(cas);
        }

        return table;
    }

    private PdfPTable createUserTable(List<Object[]> usersList) {
        float[] columnWidths = new float[]{2f, 1f};
        PdfPTable table = new PdfPTable(2);
        table.setWidths(columnWidths);

        Font cellHeader = FontFactory.getFont("Arial", 18);

        PdfPCell cell1 = new PdfPCell(new Phrase("Učitel", cellHeader));
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell1.setPaddingTop(10);
        cell1.setPaddingBottom(10);

        PdfPCell cell2 = new PdfPCell(new Phrase("Počet problémů", cellHeader));
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell2.setPaddingTop(10);
        cell2.setPaddingBottom(10);

        table.addCell(cell1);
        table.addCell(cell2);

        for (Object[] object : usersList) {
            Users user = (Users) object[0];
            Long problem_count = (Long) object[1];
            PdfPCell jmeno = new PdfPCell(new Phrase(user.getName() + " " + user.getLastName()));
            jmeno.setVerticalAlignment(Element.ALIGN_MIDDLE);
            jmeno.setPaddingBottom(5);
            jmeno.setPaddingTop(5);

            PdfPCell cas = new PdfPCell(new Phrase(problem_count.toString()));
            cas.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cas.setHorizontalAlignment(Element.ALIGN_CENTER);
            cas.setPaddingBottom(5);
            cas.setPaddingTop(5);

            table.addCell(jmeno);
            table.addCell(cas);
        }

        return table;
    }

    private String getMonth(Calendar calendar) {
        switch (calendar.get(Calendar.MONTH) - 1) {
            case 0 -> {
                return "Leden";
            }
            case 1 -> {
                return "Únor";
            }
            case 2 -> {
                return "Březen";
            }
            case 3 -> {
                return "Duben";
            }
            case 4 -> {
                return "Květen";
            }
            case 5 -> {
                return "Červen";
            }
            case 6 -> {
                return "Červenec";
            }
            case 7 -> {
                return "Srpen";
            }
            case 8 -> {
                return "Září";
            }
            case 9 -> {
                return "Říjen";
            }
            case 10 -> {
                return "Listopad";
            }
            case 11 -> {
                return "Prosinec";
            }
        }
        return "";
    }
}
