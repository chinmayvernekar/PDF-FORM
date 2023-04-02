import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddTable {

    public static final String DEST = "results/AddTable.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new AddTable().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(4);
        for(int aw = 0; aw < 18; aw++){
            if(aw == 1) {

                PdfPTable table2 = new PdfPTable(2);
                table2.setTotalWidth(new float[]{ 160, 120 });
                table2.setLockedWidth(true);
                PdfContentByte cb = writer.getDirectContent();
                // first row
                PdfPCell cell = new PdfPCell(new Phrase("M/S. G & G Pharmacy"));
                cell.setPaddingTop(9);
                cell.setPaddingLeft(8);
                cell.setFixedHeight(30);
                cell.setRowspan(3);
                cell.setBorder(Rectangle.BOX);
                cell.setColspan(2);
                table.addCell(cell);
            } else if(aw == 0)
            {
                Font customer_font = new Font();
                customer_font.setSize(10);
                customer_font.setStyle(Font.NORMAL);
                Phrase phrase =new Phrase();
                phrase.setFont(customer_font);
                phrase.add("CUSTOMER NAME : ");
                PdfPCell cell = new PdfPCell(new Phrase(phrase));
                cell.setPaddingTop(9);
                cell.setFixedHeight(30);
                cell.setBorder(Rectangle.BOX);
                table.addCell(cell);
            }
            else if (aw == 3){
                Font customer_font = new Font();
                customer_font.setSize(10);
                customer_font.setStyle(Font.NORMAL);
                Phrase phrase =new Phrase();
                phrase.setFont(customer_font);
                phrase.add("ADDRESS : ");
                PdfPCell cell = new PdfPCell(new Phrase(phrase));
                cell.setPaddingTop(9);
                cell.setFixedHeight(30);
                cell.setBorder(Rectangle.BOX);
                table.addCell(cell);
            }
            else if(aw == 5){
                table.addCell("              ");
            }
            else {
                table.addCell("SEE YOU!");
            }
        }
        document.add(table);
        document.close();
    }

}
