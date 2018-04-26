package report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ReportPDF implements ReportGenerator{

	public void GenerateReport(List<Object> list) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		try {
			PdfWriter p = PdfWriter.getInstance(document, new FileOutputStream("ReportPDF.pdf"));
			document.open();
			document.add(new Paragraph("PDF Report"));
			for(Object x : list) {
				document.add(new Paragraph(x.toString()));
			}
	        document.close();
	        p.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
