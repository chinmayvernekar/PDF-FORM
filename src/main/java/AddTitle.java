import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Simple filling out form example.
 */
public class AddTitle {

    public static final String SRC = "results/AddImage.pdf";
    public static final String DEST = "results/AddTitle.pdf";

    public static void main(String args[]) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new AddTitle().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader pdfReader =
                new PdfReader(src);

        PdfStamper pdfStamper = new PdfStamper(pdfReader,
                new FileOutputStream(dest));

            BaseFont baseFont = BaseFont.createFont(
                BaseFont.HELVETICA_BOLD,
                BaseFont.CP1252, BaseFont.EMBEDDED);
            PdfContentByte pageContentByte =  pdfStamper.getOverContent(1);
            pageContentByte.beginText();
            pageContentByte.setFontAndSize(baseFont, 11);
            pageContentByte.setTextMatrix(80, 720);
            pageContentByte.showText("======================================================================");
            pageContentByte.setTextMatrix(270,703);
            pageContentByte.showText("QUOTATION");
            pageContentByte.setTextMatrix(270,698);
            pageContentByte.showText("------------------");
            pageContentByte.endText();
        pdfStamper.close();
        System.out.println("PDF modified successfully.");
    }
}
