package com.verinite.paymentservice.service;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.verinite.paymentservice.entity.Payments;


public class AddingTableToPDF {


    private List<Payments> listUsers;
    private  String invoice;
    public AddingTableToPDF(List<Payments> listUsers, String invoce) {
        this.listUsers = listUsers;
        this.invoice=invoce;
    }

//    public static void generateQRCodeImage(String text, int width, int height, String filePath)
//            throws WriterException, IOException {
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
//
//        Path path = FileSystems.getDefault().getPath(filePath);
//        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//
//    }
//
//
//    public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
//        QRCodeWriter qrCodeWriter = new QRCodeWriter();
//        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
//
//        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
//        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
//        byte[] pngData = pngOutputStream.toByteArray();
//        return pngData;
//    }

    private void writeTableHeader(PdfPTable table) throws IOException {

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(9);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("CustomerName", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("PaymentId", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("PaymentStatus", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("TransactionId", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("AccountNumber", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Ifsc", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("BankName", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("BranchName", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Amount", font));
        table.addCell(cell);




    }

    private void writeTableData(PdfPTable table) {
        for (Payments user : listUsers) {
            table.addCell(user.getCustomerName().toUpperCase());
            table.addCell(String.valueOf(user.getPaymentId()));
            table.addCell(user.getPaymentStatus().toUpperCase());
            table.addCell(user.getTransactionId());
            table.addCell(user.getAccountNumber());
            table.addCell(user.getIfsc());
            table.addCell(user.getBankName().toUpperCase());
            table.addCell(user.getBranchName().toUpperCase());
            table.addCell(user.getAmount().toString());





        }
    }

    public void export(HttpServletResponse response, String invoice) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
        Paragraph p1 = new Paragraph(invoice);
        p1.setAlignment(Paragraph.ALIGN_RIGHT);
        Paragraph p = new Paragraph("Payment Receipt", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p1);
        document.add(p);
        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{3.5f, 3.5f, 3.5f, 3.5f, 3.5f, 3.5f, 3.5f, 3.5f, 3.5f});
        table.setSpacingBefore(10);
        writeTableHeader(table);
        writeTableData(table);
        document.add(table);
        document.close();

    }

}