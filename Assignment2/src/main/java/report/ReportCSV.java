package report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class ReportCSV implements ReportGenerator{

	public void GenerateReport(List<Object> med) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw = new PrintWriter(new File("ReportCSV.csv"));
		    for(Object x : med) {
				pw.write(x.toString()+"\n");
			}
		    pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
